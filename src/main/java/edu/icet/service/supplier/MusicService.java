package edu.icet.service.supplier;

import edu.icet.dto.supplier.Music;
import edu.icet.dto.supplier.Supplier;

import java.util.List;

public interface MusicService {
    List<Music> getAll();

    Music addMusic(Music music);

    Music searchMusic(Long id);

    Music updateMusic(Music music);

    boolean deleteMusic(Long id);

}
