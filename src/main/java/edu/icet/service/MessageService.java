package edu.icet.service;

import edu.icet.dto.Message;
import edu.icet.dto.Supplier;

import java.util.List;

public interface MessageService {
    List<Message> getAll();

    boolean addMessage(Message message);

    List<Message> searchMessage(String message);

    boolean updateMessage(Message message);

    boolean deleteMessage(Long id);
}
