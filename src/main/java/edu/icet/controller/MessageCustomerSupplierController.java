package edu.icet.controller;

import edu.icet.dto.MessageCustomerSupplier;
import edu.icet.service.system.MessageCustomerSupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/message/customer-supplier")
@RequiredArgsConstructor
@CrossOrigin
public class MessageCustomerSupplierController {

    private final MessageCustomerSupplierService messageService;


    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageCustomerSupplier handleChatMessage(MessageCustomerSupplier messageCustomerSupplier) {

        return messageService.sendMessage(messageCustomerSupplier);
    }

    @MessageMapping("/chat/update")
    @SendTo("/topic/messages")
    public MessageCustomerSupplier handleMessageUpdate(MessageCustomerSupplier messageDTO) {
        MessageCustomerSupplier messageCustomerSupplier = messageService.getMessageById(messageDTO.getMid());

        if (!messageCustomerSupplier.getCustomerId().equals(messageDTO.getCustomerId())) {
            throw new SecurityException("Unauthorized message update");
        }

        messageCustomerSupplier.setContent(messageDTO.getContent());
        messageCustomerSupplier.setSendTime(LocalDateTime.now());

        return messageService.sendMessage(messageCustomerSupplier);
    }

    @GetMapping("/customersBySupplierId")
    public ResponseEntity<List<String>> getAllCustomerIds(Long supplierId) {
        List<MessageCustomerSupplier> messages = messageService.getMessagesBySupplierId(supplierId);
        List<String> customerIds = messages.stream()
                .map(MessageCustomerSupplier::getCustomerId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }

    @GetMapping("/suppliersByCustomerId")
    public ResponseEntity<List<String>> getAllSuppliersIds(Long customerId) {
        List<MessageCustomerSupplier> messages = messageService.getMessagesByCustomerId(customerId);
        List<String> customerIds = messages.stream()
                .map(MessageCustomerSupplier::getCustomerId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }


    @GetMapping("/chat/{customerId}/{supplierId}")
    public ResponseEntity<List<MessageCustomerSupplier>> getCustomerChat(@PathVariable Long customerId, @PathVariable Long supplierId) {

        List<MessageCustomerSupplier> messages = messageService.getMessagesByIds(customerId, supplierId);

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
