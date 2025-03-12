package edu.icet.service.customer.impl;

import edu.icet.dto.Anniversary;
import edu.icet.service.customer.AnniversaryEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnniversaryEventServiceImpl implements AnniversaryEventService {

    private final List<Anniversary> anniversaryList=new ArrayList<>();

    @Override
    public boolean add(Anniversary anniversary) {
        return anniversaryList.add(anniversary);
    }

    @Override
    public List<Anniversary> getAll() {
        return anniversaryList;
    }

    @Override
    public boolean delete(Integer eventId) {
        return anniversaryList.removeIf(anniversary -> anniversary.getEventId().equals(eventId));
    }

    @Override
    public boolean update(Anniversary anniversary) {
        for(Anniversary anniversary1:anniversaryList) {
            if (anniversary1.getEventId().equals(anniversary.getEventId())) {
                anniversary1.setAnniversaryYear(anniversary.getAnniversaryYear());
                anniversary1.setWifeName(anniversary.getWifeName());
                anniversary1.setHusbandName(anniversary.getHusbandName());
                anniversary1.setDescription(anniversary.getDescription());
                return true;
            }
        }
        return false;
    }

    @Override
    public Anniversary get(Integer eventId) {
        for (Anniversary anniversary: anniversaryList){
            if (anniversary.getEventId().equals(eventId)){
                return anniversary;
            }
        }
        return null;
    }
}
