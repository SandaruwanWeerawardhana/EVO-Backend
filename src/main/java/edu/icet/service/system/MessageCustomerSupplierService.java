package edu.icet.service.system;
import edu.icet.dto.MessageCustomerSupplier;

import java.util.List;

public interface MessageCustomerSupplierService {
    MessageCustomerSupplier sendMessage(MessageCustomerSupplier message);
    boolean deleteMessage(Long mid );
    List<MessageCustomerSupplier> getAllMessages();
    MessageCustomerSupplier getMessageById(Long mid);
    MessageCustomerSupplier searchMessage(Long mid);
    List<MessageCustomerSupplier> getMessagesBySupplierId(Long supplierId);
    List<MessageCustomerSupplier> getMessagesByIds(Long customerId,Long supplierId);
    List<MessageCustomerSupplier> getMessagesByCustomerId(Long customerId);
}
