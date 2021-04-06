package ru.vas.notificationservice.exception;

import lombok.Getter;
import ru.vas.notificationservice.model.Notification;

@Getter
public class SendNotificationException extends Exception {
    private final String address;
    private final Notification notificationType;

    public SendNotificationException(String message, Notification notificationType, String address) {
        super(message);
        this.address = address;
        this.notificationType = notificationType;
    }

    public SendNotificationException(String message, Throwable cause, Notification notificationType, String address) {
        super(message, cause);
        this.address = address;
        this.notificationType = notificationType;
    }
}
