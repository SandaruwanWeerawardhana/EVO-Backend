package edu.icet.service.event.impl;

import edu.icet.dto.Wedding;
import edu.icet.service.event.WeddingEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class WeddingEventServiceImpl implements WeddingEventService {

    List<Wedding> weddingArrayList = new ArrayList<>();

    @Override
    public List<Wedding> getAll() {
        return weddingArrayList;
    }

    @Override
    public boolean add(Wedding wedding) {
        return weddingArrayList.add(wedding);
    }

    @Override
    public boolean delete(String id) {
        return weddingArrayList.removeIf(wedding -> wedding.getWeddingID().equals(id));
    }

    @Override
    public boolean update(Wedding wedding) {
        for (final Wedding wedding1 : weddingArrayList) {
            if (wedding1.getWeddingID().equals(wedding.getWeddingID())) {
                wedding1.setWeddingType(wedding.getWeddingType());
                wedding1.setDate(wedding.getDate());
                return true;
            }
        }
        return false;
    }

    @Override
    public Wedding get(String id) {
        for (final Wedding wedding1 : weddingArrayList) {
            if (wedding1.getWeddingID().equals(id)) {
                return wedding1;
            }
        }
        return null;
    }

    @Override
    public List<Wedding> getByDate(LocalDate date) {
        List<Wedding> weddingsOnDate = new ArrayList<>();
        for (Wedding wedding : weddingArrayList) {
            if (wedding.getDate().equals(date)) {
                weddingsOnDate.add(wedding);
            }
        }
        return weddingsOnDate;
    }
}