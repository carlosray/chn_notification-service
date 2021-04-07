package ru.vas.notificationservice.model;

import ru.vas.notificationservice.NotificationServiceApp;
import ru.vas.notificationservice.service.SendService;

public enum Notification {
    MAIL {
        @Override
        public SendService getSendService() {
            return NotificationServiceApp.getApplicationContext().getBean("mailSendService", SendService.class);
        }
    },
    NONE {
        @Override
        public SendService getSendService() {
            throw new UnsupportedOperationException("Тип уведомления NONE не может вернуть сервис отправки сообщений");
        }
    };

    public abstract SendService getSendService();
}
