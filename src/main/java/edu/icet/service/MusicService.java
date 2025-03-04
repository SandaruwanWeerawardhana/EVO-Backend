package edu.icet.service;

import edu.icet.dto.Music;
import edu.icet.dto.Supplier;

import java.util.List;

public interface MusicService {
    List<Music> getAll(Supplier supplier);

    boolean addMusic(Music music);

    Music searchMusic(Music music);

    boolean updateMusic(Music music);

    boolean deleteMusic(Long id);

}
