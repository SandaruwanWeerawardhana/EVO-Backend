package edu.icet.service;

import edu.icet.dto.MusicPackage;

import java.util.List;

public interface MusicPackageService {
    Boolean create(MusicPackage musicPackage);
    Boolean update(MusicPackage musicPackage);
    List<MusicPackage> getAll();
    MusicPackage getById(Integer id);
    Boolean delete(Integer id);
}



