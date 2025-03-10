package edu.icet.service.system.impl;

import edu.icet.dto.Message;
import edu.icet.service.system.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public boolean sendMessage(Message message) {
        return false;
    }

    @Override
    public boolean deleteMessage(Long mid) {
        return false;
    }

    @Override
    public List<Message> getAllMessages() {
        return List.of();
    }

    @Override
    public Message getMessageById(Long mid) {
        return null;
    }

    @Override
    public boolean isMessageDelivered(Long mid) {
        return false;
    }

    @Override
    public boolean isMessageRead(Long mid) {
        return false;
    }

    @Override
    public Message searchMessage(Long mid) {
        return null;
    }
}
