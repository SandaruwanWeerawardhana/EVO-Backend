package edu.icet.controller;

import edu.icet.dto.Message;
import edu.icet.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@CrossOrigin
public class MessageController{

    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@Valid @RequestBody Message message){
       if (messageService.sendMessage(message)){
           return new ResponseEntity<>(HttpStatus.OK);
       }else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @DeleteMapping("/delete/{mid}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long mid){
        if (messageService.deleteMessage(mid)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        final List<Message> allMessages = messageService.getAllMessages();
        if (allMessages != null){
            return new ResponseEntity<>(allMessages, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{mid}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long mid){
        final Message messageById = messageService.getMessageById(mid);
        if (messageById !=null){
            return new ResponseEntity<>(messageById, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/delivered/{mid}")
    public ResponseEntity<String> isMessageDelivered(@PathVariable Long mid){
        if (messageService.isMessageDelivered(mid)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/read/{mid}")
    public ResponseEntity<String> isMessageRead(@PathVariable Long mid){
        if (messageService.isMessageRead(mid)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/{mid}")
    public ResponseEntity<Message> searchMessage(@PathVariable Long mid){
        final Message message = messageService.searchMessage(mid);
        if (message !=null){
            return new ResponseEntity<>(message, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
