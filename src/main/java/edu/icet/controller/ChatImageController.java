package edu.icet.controller;


import edu.icet.dto.ChatImage;
import edu.icet.service.system.ChatImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier/chat/image")
@RequiredArgsConstructor
public class ChatImageController {
    private final ChatImageService chatImageService;

    @PostMapping("/create")
    public boolean create(@RequestBody ChatImage chatImage){
        return chatImageService.addChatImage(chatImage);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam(value = "id") Long id){
        return chatImageService.deleteChatImage(id);
    }


    @GetMapping("/search")
    public ChatImage getById(@RequestParam(value = "id") Long id){
        return chatImageService.getChatImage(id);
    }
}
