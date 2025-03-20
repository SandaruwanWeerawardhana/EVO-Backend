package edu.icet.service.system;

import edu.icet.dto.ChatImage;
import org.springframework.stereotype.Service;


public interface ChatImageService {
    ChatImage getChatImage(Long id);
    boolean addChatImage(ChatImage chatImage);
    boolean deleteChatImage(Long id);
}
