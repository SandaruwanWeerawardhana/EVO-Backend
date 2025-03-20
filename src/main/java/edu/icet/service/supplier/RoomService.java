package edu.icet.service.supplier;

import edu.icet.dto.Profile;
import edu.icet.dto.Room;
import java.util.List;

public interface RoomService {
    List<Room> getAll(Profile profile);
    boolean save(Room room);
    Room search(Long id);
    Boolean delete(Long id);
    Room update(Room room);
}
