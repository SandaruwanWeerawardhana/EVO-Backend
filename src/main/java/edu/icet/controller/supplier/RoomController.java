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
    final RoomService service;
    @PostMapping("/save")
    public void saveRoom(@RequestBody Room room){
        service.save(room);
    }

    @GetMapping("/getAll")
    public List<Room> getRoomData(@RequestBody Profile profile){
        return service.getAll(profile);
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room){
        return service.update(room);
    }

    @GetMapping("/search/{id}")
    public Room searchRoom(@PathVariable Long id){
        return service.search(id);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteById(@RequestParam Long id){
        return service.delete(id);
    }

}
