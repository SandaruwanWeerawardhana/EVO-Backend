package edu.icet.service.supplier;

import edu.icet.dto.supplier.Room;
import edu.icet.dto.supplier.Supplier;

import java.util.List;

public interface RoomService {
    List<Room> getAll();
    boolean save(Room room);
    Room search(Long id);
    Boolean delete(Long id);
    Room update(Room room);
}
