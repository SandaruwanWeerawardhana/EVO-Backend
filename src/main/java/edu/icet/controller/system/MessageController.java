package edu.icet.controller.system;

import edu.icet.dto.system.MessageAdminSupplier;
import edu.icet.dto.system.MessageCustomerSupplier;
import edu.icet.service.supplier.WhatsappMessageService;
import edu.icet.service.system.MessageAdminSupplierService;
import edu.icet.service.system.MessageCustomerSupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system")
@RequiredArgsConstructor
@CrossOrigin
public class MessageController {
    private final WhatsappMessageService whatsappMessageService;
    private final MessageAdminSupplierService messageAdminSupplierService;
    private final MessageCustomerSupplierService messageCustomerSupplierService;

    @PostMapping("/whatsapp/message")
    public Mono<String> sendMessage(@RequestParam(value = "message") String message){
        return whatsappMessageService.sendMessage(message);
    }

    @PostMapping("/whatsapp/notification")
    public Mono<String> sendNotification(@RequestParam(name = "id") Integer id){
        return whatsappMessageService.sendNotification(id);
    }

    @MessageMapping("/message/admin-supplier/chat/admin-supplier")
    @SendTo("/message/admin-supplier/topic/messages")
    public MessageAdminSupplier handleChatMessage(MessageAdminSupplier MessageAdminSupplier) {

        return messageAdminSupplierService.sendMessage(MessageAdminSupplier);
    }

    @MessageMapping("/message/admin-supplier/chat/admin-supplier/update")
    @SendTo("/message/admin-supplier/topic/messages")
    public MessageAdminSupplier handleMessageUpdate(MessageAdminSupplier messageDTO) {
        MessageAdminSupplier MessageAdminSupplier = messageAdminSupplierService.getMessageById(messageDTO.getMid());

        if (!MessageAdminSupplier.getAdminId().equals(messageDTO.getAdminId())) {
            throw new SecurityException("Unauthorized message update");
        }

        MessageAdminSupplier.setContent(messageDTO.getContent());
        MessageAdminSupplier.setSendTime(LocalDateTime.now());

        return messageAdminSupplierService.sendMessage(MessageAdminSupplier);
    }

    @GetMapping("/message/admin-supplier/customersBySupplierId")
    public ResponseEntity<List<String>> getAllCustomerIds(Long supplierId) {
        List<MessageAdminSupplier> messages = messageAdminSupplierService.getMessagesBySupplierId(supplierId);
        List<String> customerIds = messages.stream()
                .map(MessageAdminSupplier::getAdminId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }

    @GetMapping("/message/admin-supplier/suppliersByCustomerId")
    public ResponseEntity<List<String>> getAllSuppliersIds(Long customerId) {
        List<MessageAdminSupplier> messages = messageAdminSupplierService.getMessagesByAdminId(customerId);
        List<String> customerIds = messages.stream()
                .map(MessageAdminSupplier::getAdminId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }


    @GetMapping("/message/admin-supplier/chat/{customerId}/{supplierId}")
    public ResponseEntity<List<MessageAdminSupplier>> getCustomerChat(@PathVariable Long customerId, @PathVariable Long supplierId) {

        List<MessageAdminSupplier> messages = messageAdminSupplierService.getMessagesByIds(customerId, supplierId);

        return ResponseEntity.ok(messages);
    }

    @MessageMapping("/message/admin-supplier/message/admin-supplier/delete")
    @SendTo("/message/admin-supplier/topic/messages")
    public Long deleteMessage(Long id) {
        if (messageAdminSupplierService.deleteMessage(id)) {
            return id;
        }
        return null;

    }

    @MessageMapping("/message/customer-supplier/chat/customer-supplier")
    @SendTo("/message/customer-supplier/topic/messages")
    public MessageCustomerSupplier handleCustomerSupplierChatMessage(MessageCustomerSupplier messageCustomerSupplier) {
        return messageCustomerSupplierService.sendMessage(messageCustomerSupplier);
    }

    @MessageMapping("/message/customer-supplier/chat/customer-supplier/update")
    @SendTo("/message/customer-supplier/topic/messages")
    public MessageCustomerSupplier handleCustomerSupplierMessageUpdate(MessageCustomerSupplier messageDTO) {
        MessageCustomerSupplier messageCustomerSupplier = messageCustomerSupplierService.getMessageById(messageDTO.getMid());

        if (!messageCustomerSupplier.getCustomerId().equals(messageDTO.getCustomerId())) {
            throw new SecurityException("Unauthorized message update");
        }

        messageCustomerSupplier.setContent(messageDTO.getContent());
        messageCustomerSupplier.setSendTime(LocalDateTime.now());

        return messageCustomerSupplierService.sendMessage(messageCustomerSupplier);
    }

    @GetMapping("/message/customer-supplier/customersBySupplierId")
    public ResponseEntity<List<String>> getAllCustomersBySupplierId(Long supplierId) {
        List<MessageCustomerSupplier> messages = messageCustomerSupplierService.getMessagesBySupplierId(supplierId);
        List<String> customerIds = messages.stream()
                .map(MessageCustomerSupplier::getCustomerId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }

    @GetMapping("/message/customer-supplier/suppliersByCustomerId")
    public ResponseEntity<List<String>> getAllSuppliersByCustomerId(Long customerId) {
        List<MessageCustomerSupplier> messages = messageCustomerSupplierService.getMessagesByCustomerId(customerId);
        List<String> customerIds = messages.stream()
                .map(MessageCustomerSupplier::getCustomerId)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }


    @GetMapping("/message/customer-supplier/chat/{customerId}/{supplierId}")
    public ResponseEntity<List<MessageCustomerSupplier>> getCustomerChatWithSupplier(@PathVariable Long customerId, @PathVariable Long supplierId) {

        List<MessageCustomerSupplier> messages = messageCustomerSupplierService.getMessagesByIds(customerId, supplierId);

        return ResponseEntity.ok(messages);
    }

    @MessageMapping("/message/customer-supplier/message/customer-supplier/delete")
    @SendTo("/message/customer-supplier/topic/messages")
    public Long deleteMessageCustomerAndSupplier(Long id) {
        if (messageCustomerSupplierService.deleteMessage(id)) {
            return id;
        }
        return null;
    }
}
