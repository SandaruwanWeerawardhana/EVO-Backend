package edu.icet.service.supplier.impl;

import edu.icet.dto.SalonImage;
import edu.icet.service.supplier.SalonImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SalonImageServiceImpl implements SalonImageService {

    private final List<SalonImage> salonImages=new ArrayList<>();
    final ModelMapper modelMapper;


    @Override
    public List<SalonImage> getAll() {
        return salonImages;
    }

    @Override
    public SalonImage save(SalonImage salonImage) {
        salonImages.add(salonImage);
        return salonImage;
    }

    @Override
    public Boolean delete(Long id) {
        return salonImages.removeIf(s->s.getId().equals(id));
    }

    @Override
    public SalonImage update(SalonImage salonImage) {
        if(salonImage==null||salonImage.getId()==null) return null;

        for(SalonImage s:salonImages){
            if(s.getId().equals(salonImage.getId())){
                int index=salonImages.indexOf(s);
                salonImages.set(index,salonImage);
                return salonImage;
            }
        }
        return null;
    }
}
