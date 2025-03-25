package edu.icet.controller.supplier;

import edu.icet.dto.supplier.Music;
import edu.icet.dto.supplier.Supplier;
import edu.icet.service.supplier.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier/music")
@RequiredArgsConstructor
public class MusicController {

    final MusicService musicService;
    @PostMapping("/add")
    public void add(@RequestBody Music music){
        musicService.addMusic(music);
    }

    @GetMapping("/all")
    public List<Music> getAll(){
        return musicService.getAll(new Supplier());
    }

    @GetMapping("/search")
    public Music search(@RequestParam Long id){
        return musicService.searchMusic(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        musicService.deleteMusic(id);
    }

    @PutMapping("update")
    public void update(@RequestBody Music music){
        musicService.updateMusic(music);
    }
}
