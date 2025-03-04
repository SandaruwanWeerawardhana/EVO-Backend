package edu.icet.controller;


import edu.icet.dto.Notification;
import edu.icet.service.NotificationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@CrossOrigin

public class NotificationController {
    final NotificationService service;
    @PostMapping("/add")
    public ResponseEntity<String> addNotification(@Valid @RequestBody Notification notification) {
        service.createNotification(notification);
        return ResponseEntity.ok("Successful");
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = service.getAllNotification();
        return ResponseEntity.ok(notifications);

    }

    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<String> deleteNotification(@PathVariable Integer notificationId) {
        service.deleteNotification(notificationId);
        return ResponseEntity.ok("Successful");
    }

    @PutMapping("/update-notification")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Notification> updateNotification(@Valid @RequestBody Notification notification) {
        service.updateNotification(notification.getNotificationId(), notification);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/search-by-notificationId/{notificationId}")
    public ResponseEntity<Notification> getNotificationId(@PathVariable Integer notificationId) {
        Notification notification = service.getNotificationById(notificationId);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/search-by-type/{type}")
    public ResponseEntity<List<Notification>> getNotificationByType(@PathVariable String type) {
        List<Notification> notifications = service.getNotificationByType(type);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/search-by-status/{status}")
    public ResponseEntity<List<Notification>> getNotificationByStatus(@PathVariable String status) {
        List<Notification> notifications = service.getNotificationByStatus(status);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/search-by-delivery/{deliveryMethod}")
    public ResponseEntity<List<Notification>> getNotificationByDeliveryMethod(@PathVariable String deliveryMethod) {
        List<Notification> notifications = service.getNotificationByDeliveryMethod(deliveryMethod);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/get-unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications() {
        List<Notification> notifications = service.getUnreadNotifications();
        return ResponseEntity.ok(notifications);
    }




}
