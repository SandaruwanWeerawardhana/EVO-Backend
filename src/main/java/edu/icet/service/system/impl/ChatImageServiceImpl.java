package edu.icet.service.system.impl;

import edu.icet.dto.ChatImage;
import edu.icet.service.system.ChatImageService;
import org.springframework.stereotype.Service;

@Service
public class ChatImageServiceImpl implements ChatImageService {
    @Override
    public ChatImage getChatImage(Integer id) {
        return null;
    }

    @Override
    public boolean addChatImage(ChatImage chatImage) {
        return false;
    }

    @Override
    public boolean deleteChatImage(Integer id) {
        return false;
    }
}
