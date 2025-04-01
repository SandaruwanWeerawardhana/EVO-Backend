package edu.icet.controller.system;

import edu.icet.dto.system.MessageCustomerSupplier;
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


    @MessageMapping("/chat/customer-supplier")
    @SendTo("/topic/messages")
    public MessageCustomerSupplier handleChatMessage(MessageCustomerSupplier messageCustomerSupplier) {

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



}
