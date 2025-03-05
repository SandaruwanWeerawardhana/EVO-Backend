package edu.icet.service.impl;

import edu.icet.dto.Chat;
import edu.icet.service.ChatService;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImpl implements ChatService {
    private List<Chat> chatList = new ArrayList<>();
    @Override
    public boolean create(Chat chat) {
        return chatList.add(chat);
    }

    @Override
    public Chat getChat(Integer id) {
        for (Chat chat:chatList){
            if (chat.getId().equals(id)){
                return chat;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return chatList.removeIf(chat -> chat.getId().equals(id));
    }
}
