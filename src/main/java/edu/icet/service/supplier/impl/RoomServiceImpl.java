package edu.icet.service.supplier.impl;

import edu.icet.dto.Profile;
import edu.icet.dto.Room;
import edu.icet.service.supplier.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public List<Room> getAll(Profile profile) {
        return List.of();
    }

    @Override
    public Room save(Room room) {
        return null;
    }

    @Override
    public Room search(String query) {
        return null;
    }

    @Override
    public Boolean delete(Room room) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Room update(Room room) {
        return null;
    }
}
