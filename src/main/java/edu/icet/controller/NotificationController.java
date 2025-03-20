package edu.icet.controller;

import edu.icet.dto.Notification;
import edu.icet.service.system.NotificationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@CrossOrigin

public class NotificationController {
    private final NotificationService service;

    @PostMapping("/create")
    public ResponseEntity<Notification> createNotification(@Valid @RequestBody Notification notification) {
        if(service.createNotification(notification) !=null){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = service.getAllNotification();
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long notificationId) {
        if(service.deleteNotification(notificationId)) {
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-notification")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Notification> updateNotification(@Valid @RequestBody Notification notification) {
        if (service.updateNotification(notification.getNotificationId(),notification) !=null) {
            return new ResponseEntity<>(notification,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search-by-notificationId/{notificationId}")
    public ResponseEntity<Notification> getNotificationId(@PathVariable Long notificationId) {
        Notification notification = service.getNotificationById(notificationId);
        if (notification != null) {
            return  new ResponseEntity<>(notification,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search-by-type/{type}")
    public ResponseEntity<List<Notification>> getNotificationByType(@PathVariable String type) {
        List<Notification> notifications = service.getNotificationByType(type);
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search-by-status/{status}")
    public ResponseEntity<List<Notification>> getNotificationByStatus(@PathVariable String status) {
        List<Notification> notifications = service.getNotificationByStatus(status);
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search-by-delivery/{deliveryMethod}")
    public ResponseEntity<List<Notification>> getNotificationByDeliveryMethod(@PathVariable String deliveryMethod) {
        List<Notification> notifications = service.getNotificationByDeliveryMethod(deliveryMethod);
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("search-by-user/{usertype}/{userId}")
    public ResponseEntity<List<Notification>> getNotificationByUser(@PathVariable String userType, @PathVariable Long userId) {
        List<Notification> notifications = service.getNotificationByUser(userType, userId);
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/mark-as-read/{notificationId}")
    public ResponseEntity<String> markAsRead(@PathVariable Long notificationId) {
        if (service.markAsRead(notificationId)) {
            return ResponseEntity.ok("Notification marked as read");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found");
        }
    }

    @GetMapping("/get-unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications() {
        List<Notification> notifications = service.getUnreadNotifications();
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
