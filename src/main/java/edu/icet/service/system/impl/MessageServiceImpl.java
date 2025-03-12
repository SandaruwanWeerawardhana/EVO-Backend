package edu.icet.service.system.impl;

import edu.icet.dto.Message;
import edu.icet.service.system.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {
    List<Message>messageArrayList=new ArrayList<>();

    @Override
    public boolean sendMessage(Message message) {
        return messageArrayList.add(message);
    }

    @Override
    public boolean deleteMessage(Long mid) {
        return messageArrayList.removeIf(message -> Objects.equals(message.getMid(),mid));
    }

    @Override
    public List<Message> getAllMessages() {
        return messageArrayList;
    }

    @Override
    public Message getMessageById(Long mid) {
        for (Message message :messageArrayList){
            if (message.getMid().equals(mid)){
                return message;
            }
        }
        return  null;
    }

    @Override
    public Message searchMessage(Long mid) {
        return messageArrayList.stream().filter(message ->message.getMid().equals(mid)).findFirst().orElse(null);
    }
}
