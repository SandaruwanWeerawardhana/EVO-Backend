package edu.icet.service.system.impl;

import edu.icet.dto.Reply;
import edu.icet.service.system.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService {
    @Override
    public void addReply(Reply reply) {

    }

    @Override
    public List<Reply> getAllReplies() {
        return List.of();
    }

    @Override
    public void updateReply(Reply reply) {

    }

    @Override
    public void deleteReplyById(Long replyId) {

    }

    @Override
    public Reply searchReplyById(Long replyId) {
        return null;
    }

    @Override
    public Reply searchReplyByUserId(Long userId) {
        return null;
    }

    @Override
    public Boolean containsBadWords(String reply) {
        return null;
    }
}
