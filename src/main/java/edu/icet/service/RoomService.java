package edu.icet.service;

import edu.icet.dto.Profile;
import edu.icet.dto.Room;
import java.util.List;

public interface RoomService {
    List<Room> getAll(Profile profile);
    Room save(Room room);
    Room search(String query);
    Boolean delete(Room room);
    Boolean delete(Long id);
    Room update(Room room);
}
