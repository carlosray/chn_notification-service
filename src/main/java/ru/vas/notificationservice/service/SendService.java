package ru.vas.notificationservice.service;

import ru.vas.notificationservice.dto.SubscriptionDTO;
import ru.vas.notificationservice.dto.UserBaseDTO;
import ru.vas.notificationservice.exception.SendNotificationException;

import java.util.Set;

public interface SendService {
    void send(UserBaseDTO user, Set<SubscriptionDTO> subs) throws SendNotificationException;
}
