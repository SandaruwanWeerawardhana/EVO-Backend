package edu.icet.service.supplier.impl;

import edu.icet.dto.BeautyPackage;
import edu.icet.service.supplier.BeautyPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeautyPackageServiceImpl implements BeautyPackageService {
    private final List<BeautyPackage> beautyPackages=new ArrayList<>();

    final ModelMapper modelMapper;

    @Override
    public List<BeautyPackage> getAll() {
        return beautyPackages;
    }

    @Override
    public BeautyPackage save(BeautyPackage beautyPackage) {
        beautyPackages.add(beautyPackage);
        return beautyPackage;
    }

    @Override
    public Boolean delete(Long id) {
        return beautyPackages.removeIf(b->b.getId().equals(id));
    }

    @Override
    public BeautyPackage update(BeautyPackage beautyPackage) {
        if(beautyPackage==null||beautyPackage.getId()==null) return null;

        for(BeautyPackage b:beautyPackages){
            if(b.getId().equals(beautyPackage.getId())){
                int index=beautyPackages.indexOf(b);
                beautyPackages.set(index,beautyPackage);
                return beautyPackage;
            }
        }
        return null;
    }
}
