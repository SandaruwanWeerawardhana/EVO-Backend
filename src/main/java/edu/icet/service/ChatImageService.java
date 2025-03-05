package edu.icet.service;

import edu.icet.dto.ChatImage;

public interface ChatImageService {
    ChatImage getChatImage(Integer id);
    boolean addChatImage(ChatImage chatImage);
    boolean deleteChatImage(Integer id);
}
