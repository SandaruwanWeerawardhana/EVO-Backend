package edu.icet.service.system.impl;

import edu.icet.dto.EventSummary;
import edu.icet.service.system.EventSummaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventSummaryServiceImpl implements EventSummaryService {

    List<EventSummary> eventSummaryList=new ArrayList<>();

    @Override
    public boolean add(EventSummary eventSummary) {
       return eventSummaryList.add(eventSummary);
    }

    @Override
    public boolean update(EventSummary eventSummary) {
        for (int i = 0; i < eventSummaryList.size(); i++) {
            if (eventSummaryList.get(i).getId().equals(eventSummary.getId())) {
                eventSummaryList.set(i, eventSummary);
            }
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        for (EventSummary event : eventSummaryList) {
            if (event.getId().equals(id)) {
                eventSummaryList.remove(event);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<EventSummary> getAll() {
        return eventSummaryList;
    }

    @Override
    public EventSummary getById(Integer id) {
        for (EventSummary event : eventSummaryList) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

}
