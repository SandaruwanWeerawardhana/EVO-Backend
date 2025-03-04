package edu.icet.controller;

import edu.icet.dto.Reply;
import edu.icet.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/reply")
@RequiredArgsConstructor
@CrossOrigin

public class ReplyController {
    final ReplyService service;


    @PostMapping("/add-reply")
    public ResponseEntity<String> addReply(@RequestBody Reply reply) {
        try {
            service.addReply(reply);
            return ResponseEntity.ok("Reply added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


//    @PostMapping("/add-reply")
//    public void addReply(@RequestBody Reply reply){
//        service.addReply(reply);
//    }

    @GetMapping("/get-all-replies")
       public List<Reply>getAllReplies(){
        return service.getAllReplies();
    }
    @PutMapping("/update-reply")
      public void updateReply(@RequestBody Reply reply){
          service.updateReply(reply);
    }

@DeleteMapping("/delete-reply/{replyId}")
    public void deleteReplyById(@PathVariable Long replyId){
        service.deleteReplyById(replyId);
}

@GetMapping("/search-reply/{replyId}")
    public Reply searchReplyById(@PathVariable Long replyId){
       return service.searchReplyById(replyId);
}

@GetMapping("/search-reply-by-user-id/{userId}")
    public Reply searchReplyByUserId(@PathVariable Long userId){
     return service.searchReplyByUserId(userId);
}


}
