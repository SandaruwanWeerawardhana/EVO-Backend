package edu.icet.service.system;
import edu.icet.dto.MessageAdminSupplier;

import java.util.List;

public interface MessageAdminSupplierService {
    MessageAdminSupplier sendMessage(MessageAdminSupplier message);
    boolean deleteMessage(Long mid );
    List<MessageAdminSupplier> getAllMessages();
    MessageAdminSupplier getMessageById(Long mid);
    MessageAdminSupplier searchMessage(Long mid);
    List<MessageAdminSupplier> getMessagesBySupplierId(Long supplierId);
    List<MessageAdminSupplier> getMessagesByIds(Long adminId,Long supplierId);
    List<MessageAdminSupplier> getMessagesByAdminId(Long adminId);

}
