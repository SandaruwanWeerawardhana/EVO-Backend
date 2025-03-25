package edu.icet.controller.supplier;

import edu.icet.dto.system.Profile;
import edu.icet.dto.supplier.Room;
import edu.icet.service.supplier.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/supplier/Room")
@CrossOrigin
@RestController
public class RoomController {
    final RoomService roomService;
    @PostMapping("/save")
    public void saveRoom(@RequestBody Room room){
        roomService.save(room);
    }

    @GetMapping("/getAll")
    public List<Room> getRoomData(@RequestBody Profile profile){
        return roomService.getAll(profile);
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room){
        return roomService.update(room);
    }

    @GetMapping("/search/{id}")
    public Room searchRoom(@PathVariable Long id){
        return roomService.search(id);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteById(@RequestParam Long id){
        return roomService.delete(id);
    }

}
