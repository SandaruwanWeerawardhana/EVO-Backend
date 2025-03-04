package edu.icet.service;

import edu.icet.dto.Hall;
import edu.icet.dto.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll();
    Room save(Room room);
    Boolean delete(Room room);
    Boolean delete(Long id);
    Room update(Room room);
}
