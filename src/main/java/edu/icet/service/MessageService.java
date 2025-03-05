package edu.icet.service;

import edu.icet.dto.Chat;
import edu.icet.dto.Message;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MessageService {
    List<Message> getAll(Chat chat);

    boolean addMessage(Message message);

    List<Message> searchMessage(String message);

    boolean updateMessage(Message message);

    boolean deleteMessage(Long id);
}
