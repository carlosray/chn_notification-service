package ru.vas.notificationservice.service;

import ru.vas.notificationservice.dto.SubscriptionDTO;

import java.util.Set;

public interface SubscriptionService {
    Set<SubscriptionDTO> setStatuses(Set<SubscriptionDTO> subs);
}
