package edu.icet.service.event.impl;

import edu.icet.dto.event.GetTogether;
import edu.icet.service.event.GetTogetherEventService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GetTogetherEventServiceImpl implements GetTogetherEventService {
    private final List<GetTogether> getTogetherList = new ArrayList<>();

    @Override
    public boolean add(GetTogether getTogether) {
        return getTogetherList.add(getTogether);
    }

    @Override
    public boolean delete(Integer id) {
        return getTogetherList.removeIf(getTogether -> getTogether.getEventID().equals(id));
    }

    @Override
    public List<GetTogether> getAll() {
        return getTogetherList;
    }

    @Override
    public boolean update(GetTogether getTogether) {
        for (int a=0;a<getTogetherList.size();a++) {
            if (getTogetherList.get(a).getEventID().equals(getTogether.getEventID())) {
                getTogetherList.set(a, getTogether);
                return true;
            }
        }
        return false;
    }

    @Override
    public GetTogether get(Integer id) {
        for (GetTogether getTogether : getTogetherList) {
                if (getTogether.getEventID().equals(id)) {
                    return getTogether;
                }
            }
            return null;
        }
    }




