package edu.icet.service.impl;


import edu.icet.dto.ChatImage;
import edu.icet.service.ChatImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatImageServiceImpl implements ChatImageService {
    private List<ChatImage> chatImageList = new ArrayList<>();

    @Override
    public ChatImage getChatImage(Integer id) {
        for (ChatImage ci:chatImageList){
            if (ci.getId().equals(id)){
                return ci;
            }
        }
        return null;
    }

    @Override
    public boolean addChatImage(ChatImage chatImage) {
        return chatImageList.add(chatImage);
    }

    @Override
    public boolean deleteChatImage(Integer id) {
        return chatImageList.removeIf(chatImage -> chatImage.getId().equals(id));
    }
}
