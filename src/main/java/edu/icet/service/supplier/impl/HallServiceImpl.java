package edu.icet.service.supplier.impl;

import edu.icet.dto.Hall;
import edu.icet.dto.MusicPackage;
import edu.icet.dto.Profile;
import edu.icet.service.supplier.HallService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final List<Hall> hallList=new ArrayList<>();
    private ModelMapper modelMapper;

    @Override
    public List<Hall> getAll(Profile profile) {
        List<Hall> result=new ArrayList<>();
        for(Hall h:hallList){
            if(h.getPropertyId().equals(profile.getId())){
                result.add(h);
            }
        }
        return result;
    }

    @Override
    public Hall save(Hall hall) {
        hallList.add(hall);
        return hall;
    }

    @Override
    public Hall search(String query) {
        Long id=Long.parseLong(query);
        return hallList.stream()
                .filter(h -> h.getHallId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));
    }

    @Override
    public Boolean delete(Hall hall) {
        return hallList.remove(hall);
    }

    @Override
    public Boolean delete(Long id) {
        return hallList.removeIf(h -> h.getHallId().equals(id));
    }

    @Override
    public Hall update(Hall hall) {
        if(hall==null||hall.getHallId()==null) return null;

        for(int i=0;i<hallList.size();i++){
            if(hallList.get(i).getHallId().equals(hall.getHallId())){
                hallList.set(i,hall);
                return hall;
            }
        }
        return null;
    }
}
