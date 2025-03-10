package edu.icet.service.system;
import edu.icet.dto.Message;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    boolean sendMessage(Message message);
    boolean deleteMessage(Long mid );
    List<Message> getAllMessages();
    Message getMessageById(Long mid);
    boolean isMessageDelivered(Long mid);
    boolean isMessageRead(Long mid);
    Message searchMessage(Long mid);
}
