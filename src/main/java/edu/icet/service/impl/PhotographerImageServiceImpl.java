package edu.icet.service.impl;

import edu.icet.dto.PhotographerImage;
import edu.icet.service.PhotographerImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotographerImageServiceImpl implements PhotographerImageService {

    private final List<PhotographerImage> photographerImages=new ArrayList<>();

    final ModelMapper modelMapper;

    @Override
    public List<PhotographerImage> getAll() {
        return photographerImages;
    }

    @Override
    public PhotographerImage save(PhotographerImage photographerImage) {
        photographerImages.add(photographerImage);
        return photographerImage;
    }

    @Override
    public Boolean delete(Long id) {
        return photographerImages.removeIf(p->p.getId().equals(id));
    }

    @Override
    public PhotographerImage update(PhotographerImage photographerImage) {
        if(photographerImage==null||photographerImage.getId()==null) return null;

        for(PhotographerImage p:photographerImages){
            if(p.getId().equals(photographerImage.getId())){
                int index=photographerImages.indexOf(p);
                photographerImages.set(index,photographerImage);
                return photographerImage;
            }
        }
        return null;
    }
}
