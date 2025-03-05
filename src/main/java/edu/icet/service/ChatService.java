package edu.icet.service;

import edu.icet.dto.Chat;

public interface ChatService {
    boolean create(Chat chatService);
    Chat getChat(Integer id);
    boolean delete(Integer id);
}
