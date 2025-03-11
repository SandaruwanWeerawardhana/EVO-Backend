package edu.icet.service.supplier.impl;

import edu.icet.dto.Profile;
import edu.icet.dto.Room;
import edu.icet.service.supplier.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    private final List<Room> roomList = new ArrayList<>();

    @Override
    public List<Room> getAll(Profile profile) {
        return roomList;
    }

    @Override
    public boolean save(Room room) {
        roomList.add(room);
        return false;
    }

    @Override
    public Room search(Long id) {
        for (Room room:roomList){
            if (room.getRoomId()==id){
                return room;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Room room) {
        return roomList.removeIf(room1 -> room1.equals(room));
    }

    @Override
    public Boolean delete(Long id) {
        return roomList.removeIf(room1 -> room1.getRoomId().equals(id));
    }



    @Override
    public Room update(Room room) {
        for (Room roomEntity : roomList) {
            if (roomEntity.getRoomId().equals(room.getRoomId())) {
                roomEntity.getPropertyId().equals(room.getPropertyId());
                roomEntity.getBeds().equals(room.getBeds());
            }
        }
        return null;
    }
}
