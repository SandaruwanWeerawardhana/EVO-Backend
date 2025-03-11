package edu.icet.service.system.impl;

import edu.icet.dto.Reply;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class ReplyServiceImpl implements edu.icet.service.system.ReplyService {
    private final ModelMapper mapper;
    private List<Reply>replyList=new ArrayList<>();
    @Override
    public List<Reply> addReply(Reply reply) {
        replyList.add(reply);
        return replyList;
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyList;
    }

    @Override
    public Reply updateReply(Reply reply) {
        for (int i=0;i<replyList.size();i++) {
            if(replyList.get(i).getReplyId().equals(reply.getReplyId())){
                replyList.set(i, reply);
                return reply;
            }
        }
        return null;
    }


    @Override
    public void deleteReplyById(Long replyId) {
        replyList.removeIf(reply -> reply.getReplyId().equals(replyId));
    }

    @Override
    public Reply searchReplyById(Long replyId) {
        return replyList.stream()
                .filter(reply -> reply.getReplyId().equals(replyId))
                .findFirst()
                .orElse(null);
    }


    @Override
    public Reply searchReplyByUserId(Long userId) {
        return replyList.stream()
                .filter(reply -> reply.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean containsBadWords(String reply) {

        return null;
    }
}
