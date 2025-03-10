package edu.icet.service.supplier;

import edu.icet.dto.MusicPackage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MusicPackageService {
    Boolean create(MusicPackage musicPackage);
    Boolean update(MusicPackage musicPackage);
    List<MusicPackage> getAll();
    MusicPackage getById(Integer id);
    Boolean delete(Integer id);
}



