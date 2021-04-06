package ru.vas.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vas.notificationservice.dto.NotificationDTO;
import ru.vas.notificationservice.dto.SubscriptionDTO;
import ru.vas.notificationservice.feign.RestCoreClient;
import ru.vas.notificationservice.model.Notification;
import ru.vas.notificationservice.service.NotificationChecker;
import ru.vas.notificationservice.service.SubscriptionService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationCheckerImpl implements NotificationChecker {
    private final RestCoreClient restCoreClient;
    private final SubscriptionService subscriptionService;

    @Override
    public Set<NotificationDTO> check() {
        final Set<SubscriptionDTO> allSubscriptions = restCoreClient.getAllSubscriptions();
        final Set<SubscriptionDTO> subsWithStatuses = subscriptionService.setStatuses(allSubscriptions);
        return subsWithStatuses.stream()
                .filter(sub -> sub.getNotification() != Notification.NONE)
                .filter(SubscriptionDTO::getStatus)
                .collect(Collectors.groupingBy(SubscriptionDTO::getUser, Collectors.toSet()))
                .entrySet().stream()
                .map(NotificationDTO::new)
                .collect(Collectors.toSet());
    }
}
