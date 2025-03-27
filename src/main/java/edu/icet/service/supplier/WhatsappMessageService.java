package edu.icet.service.supplier;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface WhatsappMessageService {
    Mono<String> sendNotification(Integer id);
    Mono<String> sendMessage(String message);
}
