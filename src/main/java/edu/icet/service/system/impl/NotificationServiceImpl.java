package edu.icet.service.system.impl;

import edu.icet.dto.Notification;
import edu.icet.service.system.NotificationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

public class NotificationServiceImpl implements NotificationService {

    List<Notification> notificationList = new ArrayList<>();

    @Override
    public Notification createNotification(@Valid Notification notification) {
        if (notification != null) {
            notificationList.add(notification);
            return notification;
        }
        return null;
    }

    @Override
    public Notification getNotificationById(Long notificationId) {
        if (notificationId != null) {
            return notificationList.stream()
                    .filter(notification -> notification.getNotificationId().equals(notificationId))
                    .findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public Notification updateNotification(Long notificationId, Notification notification) {
        if (notificationId != null && notification != null) {
            for (int i = 0; i < notificationList.size(); i++){
                if (notificationList.get(i).getNotificationId().equals(notificationId)){
                    notificationList.set(i,notification);
                    return notification;
                }
            }
        }
        return null;
    }
    @Override
    public boolean deleteNotification(Long notificationId) {
        if (notificationId != null) {
            return notificationList
                    .removeIf(notification -> notification.getNotificationId()
                            .equals(notificationId));
        }
        return false;
    }
    @Override
    public List<Notification> getAllNotification() {
        return notificationList;
    }

    @Override
    public List<Notification> getNotificationByType(String type) {
        if (type != null) {
            return notificationList.stream()
                    .filter(notification -> notification.getType().equals(type)).toList();
        }
        return List.of();
    }

    @Override
    public List<Notification> getNotificationByStatus(String status) {
        if (status != null) {
            return notificationList.stream()
                    .filter(notification -> notification.getStatus().equals(status)).toList();
        }
        return List.of();
    }

    @Override
    public List<Notification> getNotificationByDeliveryMethod(String deliveryMethod) {
        if (deliveryMethod != null) {
            return notificationList.stream()
                    .filter(notification -> notification.getDeliveryMethod().equals(deliveryMethod)).toList();
        }
        return List.of();
    }

    @Override
    public boolean markAsRead(Long notificationId) {
        if (notificationId != null){
            for (Notification notification : notificationList){
                if (notification.getNotificationId().equals(notificationId)){
                    notification.setReadAt(LocalDate.now());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Notification> getUnreadNotifications() {
        return notificationList.stream()
                .filter(notification -> notification.getReadAt() == null).toList();
    }
}
