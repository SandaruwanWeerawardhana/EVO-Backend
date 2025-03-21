package edu.icet.controller;

import edu.icet.dto.MessageAdminSupplier;
import edu.icet.service.system.MessageAdminSupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/messageAdminSupplier")
@RequiredArgsConstructor
@CrossOrigin
public class MessageAdminSupplierController {

    private final MessageAdminSupplierService messageService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageAdminSupplier handleChatMessage(MessageAdminSupplier MessageAdminSupplier) {

        return messageService.sendMessage(MessageAdminSupplier);
    }

    @MessageMapping("/chat/update")
    @SendTo("/topic/messages")
    public MessageAdminSupplier handleMessageUpdate(MessageAdminSupplier messageDTO) {
        MessageAdminSupplier MessageAdminSupplier = messageService.getMessageById(messageDTO.getMid());

        if (!MessageAdminSupplier.getAdminId().equals(messageDTO.getAdminId())) {
            throw new SecurityException("Unauthorized message update");
        }

        MessageAdminSupplier.setContent(messageDTO.getContent());
        MessageAdminSupplier.setSendTime(LocalDateTime.now());

        return messageService.sendMessage(MessageAdminSupplier);
    }

    @GetMapping("/customersBySupplierId")
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


    @GetMapping("/chat/{customerId}/{supplierId}")
    public ResponseEntity<List<MessageAdminSupplier>> getCustomerChat(@PathVariable Long customerId, @PathVariable Long supplierId) {

        List<MessageAdminSupplier> messages = messageService.getMessagesByIds(customerId, supplierId);

        return ResponseEntity.ok(messages);
    }

    @MessageMapping("/message/delete")
    @SendTo("/topic/messages")
    public Long deleteMessage(Long id) {
        if (messageService.deleteMessage(id)) {
            return id;
        }
        return null;
    }
}
