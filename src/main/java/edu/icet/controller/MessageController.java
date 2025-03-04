package edu.icet.controller;

import edu.icet.dto.Message;
import edu.icet.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@CrossOrigin
public class MessageController{

    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@Valid @RequestBody Message message){
        messageService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
    @DeleteMapping("/delete/{mid}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long mid){
        messageService.deleteMessage(mid);
        return ResponseEntity.ok("Message delete successfully");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok(messageService.getAllMessages());
    }
    @GetMapping("/{mid}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long mid){
        return ResponseEntity.ok(messageService.getMessageById(mid));
    }
    @GetMapping("/delivered/{mid}")
    public ResponseEntity<Boolean> isMessageDelivered(@PathVariable Long mid){
        return ResponseEntity.ok(messageService.isMessageDelivered(mid));
    }
    @GetMapping("/read/{mid}")
    public ResponseEntity<Boolean> isMessageRead(@PathVariable Long mid){
        return ResponseEntity.ok(messageService.isMessageRead(mid));
    }
    @GetMapping("/search/{mid}")
    public ResponseEntity<Message> searchMessage(@PathVariable Long mid){
        return ResponseEntity.ok(messageService.searchMessage(mid));
    }
}
