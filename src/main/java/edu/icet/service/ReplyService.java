package edu.icet.service;

import edu.icet.dto.Reply;

import java.util.List;

public interface ReplyService {

    void addReply(Reply reply);

    List<Reply>getAllReplies();

    void updateReply(Reply reply);

    void deleteReplyById(Long replyId);

    Reply searchReplyById(Long replyId);

    Reply searchReplyByUserId(Long userId);

    Boolean containsBadWords(String reply);

}
