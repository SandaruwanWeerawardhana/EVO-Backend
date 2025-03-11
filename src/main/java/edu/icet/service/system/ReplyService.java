package edu.icet.service.system;

import edu.icet.dto.Reply;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {

    List<Reply> addReply(Reply reply);

    List<Reply>getAllReplies();

    Reply updateReply(Reply reply);

    void deleteReplyById(Long replyId);

    Reply searchReplyById(Long replyId);

    Reply searchReplyByUserId(Long userId);

    Boolean containsBadWords(String reply);

}
