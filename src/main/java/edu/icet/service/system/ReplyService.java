package edu.icet.service.system;

import edu.icet.dto.Reply;
import edu.icet.entity.ReplyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {


    void addReply(Reply reply) throws IllegalArgumentException;

    List<Reply> getAllReplies();

    void updateReply(Reply reply);

    void deleteReplyById(Long replyId);

    ReplyEntity searchReplyById(Long replyId);

    Reply searchReplyByUserId(Long userId);

    boolean containsBadWords(String reply);

}
