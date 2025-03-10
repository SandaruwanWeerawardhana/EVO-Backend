package edu.icet.service.supplier.impl;

import edu.icet.dto.Music;
import edu.icet.dto.Supplier;
import edu.icet.service.supplier.MusicService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Override
    public List<Music> getAll(Supplier supplier) {
        return List.of();
    }

    @Override
    public boolean addMusic(Music music) {
        return false;
    }

    @Override
    public Music searchMusic(String qurey) {
        return null;
    }

    @Override
    public boolean updateMusic(Music music) {
        return false;
    }

    @Override
    public boolean deleteMusic(Long id) {
        return false;
    }
}
