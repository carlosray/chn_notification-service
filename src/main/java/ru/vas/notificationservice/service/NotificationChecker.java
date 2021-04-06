package ru.vas.notificationservice.service;

import ru.vas.notificationservice.dto.NotificationDTO;

import java.util.Set;

public interface NotificationChecker {
    Set<NotificationDTO> check();
}
