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

    private ModelMapper modelMapper;
    private final List<Hall> hallServiceList = new ArrayList<>();
  
    @Override
    public List<Hall> getAll(Profile profile) {
        return hallServiceList;
    }

    @Override
    public Hall save(Hall hall) {
        hallServiceList.add(hall);
        return hall;
    }

    @Override
    public Hall search(Hall hall) {
        for (Hall hallTest : hallServiceList){
            if (hallTest.getHallId().equals(hall.getHallId())){
                return hallTest;
            }
        }
        return null;
    }

    public Hall search(String query) {
        Long id=Long.parseLong(query);
        return hallServiceList.stream()
                .filter(h -> h.getHallId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));
    }

    @Override
    public Boolean delete(Hall hall) {
        return hallServiceList.removeIf(hallCheck -> hallCheck.getHallId().equals(hall.getHallId()));
    }

    @Override
    public Boolean delete(Long id) {

        return hallServiceList.removeIf(hall -> hall.getHallId().equals(id));
    }

    @Override
    public Hall update(Hall hall) {

        for (int a=0;a<hallServiceList.size();a++){
            if (hallServiceList.get(a).getHallId().equals(hall.getHallId())){
                hall.setHallId(hall.getHallId());
                hallServiceList.set(a,hall);
                return hall;
            }
        }
        return null;
    }
}

