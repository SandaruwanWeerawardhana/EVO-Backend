package edu.icet.service.impl;

import edu.icet.dto.MusicPackage;
import edu.icet.service.MusicPackageService;

import java.util.ArrayList;
import java.util.List;

public class MusicPackageServiceImpl implements MusicPackageService {
   private List<MusicPackage> musicPackageList = new ArrayList<>();
    @Override
    public Boolean create(MusicPackage musicPackage) {
        return musicPackageList.add(musicPackage);
    }

    @Override
    public Boolean update(MusicPackage musicPackage) {
        for (MusicPackage mp:musicPackageList){
            if (mp.getId().equals(musicPackage.getId())){
                mp.setDescription(musicPackage.getDescription());
                mp.setPrice_per_hour(musicPackage.getPrice_per_hour());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MusicPackage> getAll() {
        return musicPackageList;
    }

    @Override
    public MusicPackage getById(Integer id) {
        for (MusicPackage mp:musicPackageList){
            if(mp.getId().equals(id))return mp;
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return musicPackageList.removeIf(musicPackage -> musicPackage.getId().equals(id));
    }
}
