package edu.icet.service;
import edu.icet.dto.Message;
import java.util.List;

public interface MessageService {
    void sendMessage(Message message);
    void deleteMessage(Long mid );
    List<Message> getAllMessages();
    Message getMessageById(Long mid);
    boolean isMessageDelivered(Long mid);
    boolean isMessageRead(Long mid);
    Message searchMessage(Long mid);
}
