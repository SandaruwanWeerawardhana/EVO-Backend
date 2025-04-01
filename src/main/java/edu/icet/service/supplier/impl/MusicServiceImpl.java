package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Music;
import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.supplier.MusicEntity;
import edu.icet.repository.supplier.MusicRepository;
import edu.icet.service.supplier.MusicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class MusicServiceImpl implements MusicService {
    private ModelMapper mapper;
    private MusicRepository repository;

    @Override
    public List<Music> getAll() {

        return repository.findAll()
                .stream()
                .map(musicEntity -> mapper.map(musicEntity, Music.class))
                .toList();
    }

    @Override
    public Music addMusic(Music music) {
        return mapper.map(repository.save(mapper.map(music, MusicEntity.class)), Music.class);
    }

    @Override
    public Music searchMusic(Long id) {

            return mapper.map(
                    repository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Music not found with ID: " + id)), Music.class
            );
    }

    @Override
    public Music updateMusic(Music music) {
        if (repository.existsById(music.getMusicID())) {

           return mapper.map(repository.save(mapper.map(music, MusicEntity.class)), Music.class);
        }

        throw new IllegalArgumentException("Music does not exist!");
    }

    @Override
    public boolean deleteMusic(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
