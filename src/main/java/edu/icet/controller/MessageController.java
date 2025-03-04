package edu.icet.controller;

import edu.icet.dto.Chat;
import edu.icet.dto.Message;
import edu.icet.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier/message")
@RequiredArgsConstructor
public class MessageController {

    final MessageService messageService;
    @PostMapping("/add")
    public void add(@RequestBody Message message){
        messageService.addMessage(message);
    }

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll(new Chat());
    }

    @GetMapping("/search/{id}")
    public List<Message> search(@PathVariable String id){
        return messageService.searchMessage(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        messageService.deleteMessage(id);
    }

    @PutMapping("update")
    public void update(@RequestBody Message message){
        messageService.updateMessage(message);
    }
}
