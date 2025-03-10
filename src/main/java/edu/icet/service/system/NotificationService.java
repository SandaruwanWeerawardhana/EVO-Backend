package edu.icet.service.system;

import edu.icet.dto.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NotificationService {
     boolean deleteNotification(Long notificationId);
     Notification getNotificationById(Long notificationId);
    Notification createNotification(Notification notification);
    Notification getNotificationById(Integer notificationId);
    Notification updateNotification(Integer notificationId, Notification notification);
    boolean deleteNotification(Integer notificationId);
    List<Notification> getAllNotification();
    List<Notification> getNotificationByType(String type);
    List<Notification> getNotificationByStatus(String status);
    List<Notification> getNotificationByDeliveryMethod(String deliveryMethod);
    boolean markAsRead(Integer notificationId);
    List<Notification> getUnreadNotifications();
}












