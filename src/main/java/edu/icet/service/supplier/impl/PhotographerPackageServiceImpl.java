package edu.icet.service.supplier.impl;

import edu.icet.dto.PhotographerImage;
import edu.icet.dto.PhotographerPackage;
import edu.icet.service.supplier.PhotographerPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PhotographerPackageServiceImpl implements PhotographerPackageService {

    private final List<PhotographerPackage> photographerPackages=new ArrayList<>();
    final ModelMapper modelMapper;

    @Override
    public List<PhotographerPackage> getAll() {
        return photographerPackages;
    }

    @Override
    public PhotographerPackage save(PhotographerPackage photographerPackage) {
        photographerPackages.add(photographerPackage);
        return photographerPackage;
    }

    @Override
    public Boolean delete(Long id) {
        return photographerPackages.removeIf(p->p.getId().equals(id));
    }

    @Override
    public PhotographerPackage update(PhotographerPackage photographerPackage) {
        if(photographerPackage==null||photographerPackage.getId()==null) return null;

        for(PhotographerPackage p:photographerPackages){
            if(p.getId().equals(photographerPackage.getId())){
                int index=photographerPackages.indexOf(p);
                photographerPackages.set(index,photographerPackage);
                return photographerPackage;
            }
        }
        return null;
    }
}
