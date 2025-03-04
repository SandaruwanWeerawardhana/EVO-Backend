package edu.icet.controller;

import edu.icet.dto.Chat;
import edu.icet.dto.Message;
import edu.icet.dto.Music;
import edu.icet.dto.Supplier;
import edu.icet.service.MessageService;
import edu.icet.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier/music")
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

    @GetMapping("/search/{id}")
    public Music search(@PathVariable String id){
        return musicService.searchMusic(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        musicService.deleteMusic(id);
    }

    @PutMapping("update")
    public void update(@RequestBody Music music){
        musicService.updateMusic(music);
    }
}
