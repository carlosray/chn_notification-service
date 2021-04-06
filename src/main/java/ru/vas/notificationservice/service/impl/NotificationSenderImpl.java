package ru.vas.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vas.notificationservice.dto.NotificationDTO;
import ru.vas.notificationservice.exception.SendNotificationException;
import ru.vas.notificationservice.service.NotificationChecker;
import ru.vas.notificationservice.service.NotificationSender;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationSenderImpl implements NotificationSender {
    private final NotificationChecker notificationChecker;

    @Override
    public void sendNotifications() {
        final Set<NotificationDTO> notifications = notificationChecker.check();
        notifications.forEach(notificationDTO -> {
            notificationDTO.getSubs().forEach((notificationType, subs) -> {
                try {
                    notificationType.getSendService().send(notificationDTO.getUser(), subs);
                } catch (SendNotificationException e) {
                    log.error(String.format("Ошибка отправки уведомления с типом '%s' на адрес '%s': %s", e.getNotificationType().name(), e.getAddress(), e.getMessage()), e);
                }
            });
        });
    }
}
