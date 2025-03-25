package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.MusicPackage;
import edu.icet.service.supplier.MusicPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MusicPackageServiceImpl implements MusicPackageService {

    private final List<MusicPackage> musicPackages=new ArrayList<>();
    final ModelMapper modelMapper;

    @Override
    public Boolean create(MusicPackage musicPackage) {
        return musicPackage!=null&&musicPackages.add(musicPackage);
    }

    @Override
    public Boolean update(MusicPackage musicPackage) {
        if(musicPackage==null||musicPackage.getId()==null) return false;

        for(MusicPackage m:musicPackages){
            if(m.getId().equals(musicPackage.getId())){
                int index=musicPackages.indexOf(m);
                musicPackages.set(index,musicPackage);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MusicPackage> getAll() {
        return musicPackages;
    }

    @Override
    public MusicPackage getById(Integer id) {
        for(MusicPackage m:musicPackages){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return musicPackages.removeIf(m->m.getId().equals(id));
    }

}
