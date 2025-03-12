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
        for (EventSummary event : eventSummaryList) {
            if (event.getId().equals(eventSummary.getId())) {
                event.setEventId(eventSummary.getEventId());
                event.setVenueId(eventSummary.getVenueId());
                event.setCustomerId(eventSummary.getCustomerId());
                event.setSupplierList(eventSummary.getSupplierList());
                event.setTotalPrice(eventSummary.getTotalPrice());
                return true;
            }
        }
        return false;
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
    public List<EventSummary> getall() {
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
