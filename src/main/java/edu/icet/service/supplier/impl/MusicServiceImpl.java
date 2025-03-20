package edu.icet.service.supplier.impl;

import edu.icet.dto.Music;
import edu.icet.dto.Supplier;
import edu.icet.entity.MusicEntity;
import edu.icet.repository.MusicRepository;
import edu.icet.service.supplier.MusicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MusicServiceImpl implements MusicService {
    private ModelMapper mapper;
    private MusicRepository repository;

    @Override
    public List<Music> getAll(Supplier supplier) {

        return repository.findAll()
                .stream()
                .map(musicEntity -> mapper.map(musicEntity, Music.class))
                .toList();
    }

    @Override
    public boolean addMusic(Music music) {
        return !repository.existsById(music.getSupplierId()) &&
                repository.save(mapper.map(music, MusicEntity.class)) != null;
    }

    @Override
    public Music searchMusic(Long id) {

            return mapper.map(
                    repository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Music not found with ID: " + id)), Music.class
            );
    }

    @Override
    public boolean updateMusic(Music music) {
        return repository.existsById(music.getSupplierId()) &&
                repository.save(mapper.map(music, MusicEntity.class)) != null;
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
