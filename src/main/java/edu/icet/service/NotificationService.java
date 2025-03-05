package edu.icet.service;

import edu.icet.dto.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(Notification notification);
    Notification getNotificationById(Integer notificationId);
    Notification updateNotification(Integer notificationId, Notification notification);
    void deleteNotification(Integer notificationId);
    List<Notification> getAllNotification();
    List<Notification> getNotificationByType(String type);
    List<Notification> getNotificationByStatus(String status);
    List<Notification> getNotificationByDeliveryMethod(String deliveryMethod);
    void markAsRead(Integer notificationId);
    List<Notification> getUnreadNotifications();
}












