package edu.icet.controller.system;

import edu.icet.dto.system.MessageAdminSupplier;
import edu.icet.service.system.MessageAdminSupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/system/message/admin-supplier")
@RequiredArgsConstructor
@CrossOrigin
public class MessageAdminSupplierController {

    private final MessageAdminSupplierService messageService;

    @MessageMapping("/chat/admin-supplier/{supplierId}/{adminId}")
    @SendTo("/topic/chat/{supplierId}/{adminId}")
    public MessageAdminSupplier handleChatMessage(
            MessageAdminSupplier message,
            @DestinationVariable Long supplierId,
            @DestinationVariable Long adminId) {

        // Validate path variables match message content
        if (!supplierId.equals(message.getSupplierId()) || !adminId.equals(message.getAdminId())) {
            throw new IllegalArgumentException("Path variables don't match message content");
        }

        return messageService.sendMessage(message);
    }

    @MessageMapping("/chat/admin-supplier/update")
    @SendTo("/topic/messages")
    public MessageAdminSupplier handleMessageUpdate(MessageAdminSupplier messageDTO) {
        MessageAdminSupplier MessageAdminSupplier = messageService.getMessageById(messageDTO.getMid());

        if (!MessageAdminSupplier.getAdminId().equals(messageDTO.getAdminId())) {
            throw new SecurityException("Unauthorized message update");
        }

        MessageAdminSupplier.setContent(messageDTO.getContent());
        MessageAdminSupplier.setSendTime(Instant.from(LocalDateTime.now()));

        return messageService.sendMessage(MessageAdminSupplier);
    }

    @GetMapping("/adminsBySupplierId")
    public ResponseEntity<List<String>> getAllCustomerIds(Long supplierId) {
        List<MessageAdminSupplier> messages = messageService.getMessagesBySupplierId(supplierId);
        List<String> customerIds = messages.stream()
                .map(MessageAdminSupplier::getAdminId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }

    @GetMapping("/suppliersByCustomerId")
    public ResponseEntity<List<String>> getAllSuppliersIds(Long customerId) {
        List<MessageAdminSupplier> messages = messageService.getMessagesByAdminId(customerId);
        List<String> customerIds = messages.stream()
                .map(MessageAdminSupplier::getAdminId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }


    @GetMapping("/chat/{AdminId}/{supplierId}")
    public ResponseEntity<List<MessageAdminSupplier>> getCustomerChat(@PathVariable Long AdminId, @PathVariable Long supplierId) {

        List<MessageAdminSupplier> messages = messageService.getMessagesByIds(AdminId, supplierId);

        return ResponseEntity.ok(messages);
    }

    @MessageMapping("/message/admin-supplier/delete")
    @SendTo("/topic/messages")
    public Long deleteMessage(Long id) {
        if (messageService.deleteMessage(id)) {
            return id;
        }
        return null;

    }
}
