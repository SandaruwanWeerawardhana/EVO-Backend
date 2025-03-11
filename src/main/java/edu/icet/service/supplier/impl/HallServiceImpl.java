package edu.icet.service.supplier.impl;

import edu.icet.dto.Hall;
import edu.icet.dto.Profile;
import edu.icet.service.supplier.HallService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HallServiceImpl implements HallService {
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
                hallServiceList.set(a,hall);
                return hall;
            }
        }
        return null;
    }
}

