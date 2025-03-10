package edu.icet.controller;


import edu.icet.dto.Chat;
import edu.icet.service.system.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;


    @PostMapping("/create")
    public boolean create(@RequestBody Chat chat){
        return chatService.create(chat);
    }


    @GetMapping("/get-chat")
    public Chat getChat(@RequestParam(value = "id") Integer id){
        return chatService.getChat(id);
    }


    @DeleteMapping("/delete")
    public boolean delete(@RequestParam(value = "id") Integer id){
        return chatService.delete(id);
    }

}
