package edu.icet.service.system;

import edu.icet.dto.Chat;
import org.springframework.stereotype.Service;


public interface ChatService {
    boolean create(Chat chat);
    Chat getChat(Integer id);
    boolean delete(Integer id);
}
