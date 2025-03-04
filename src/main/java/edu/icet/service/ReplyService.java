package edu.icet.service;

import edu.icet.dto.Reply;

import java.util.List;

public interface ReplyService {

    void addReply(Reply reply);

    List<Reply>getAllReplies();

    void updateReply(Reply reply);

    void deleteReplyById(Long replyId);

    Reply searchById(Long replyId);

    Reply searchByUserId(Long userId);

    void deleteReply(Reply reply);
}
