package edu.icet.service;

import edu.icet.dto.Reply;

import java.util.List;

public interface ReplyService {
    Reply saveReply(Reply reply);
    Reply getReplyByReplyId(Long id);
    List<Reply> getAllReply();
    boolean deleteReplyById(Long id);
    Reply getReplyByReviewId(Long id);
    Reply getReplyByUserId();
}
