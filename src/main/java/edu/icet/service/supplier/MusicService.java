package edu.icet.service.supplier;

import edu.icet.dto.Music;
import edu.icet.dto.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MusicService {
    List<Music> getAll(Supplier supplier);

    boolean addMusic(Music music);

    Music searchMusic(Long id);

    boolean updateMusic(Music music);

    boolean deleteMusic(Long id);

}
