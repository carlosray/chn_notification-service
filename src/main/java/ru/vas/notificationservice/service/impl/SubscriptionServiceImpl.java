package ru.vas.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vas.notificationservice.dto.CheckStatusDTO;
import ru.vas.notificationservice.dto.SubscriptionDTO;
import ru.vas.notificationservice.feign.DataServiceClient;
import ru.vas.notificationservice.service.SubscriptionService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final DataServiceClient dataServiceClient;

    @Override
    public Set<SubscriptionDTO> setStatuses(Set<SubscriptionDTO> subs) {
        final Set<CheckStatusDTO> statuses = getBlockedStatuses(subs);
        subs.forEach(sub -> sub.setStatus(statuses.contains(new CheckStatusDTO(sub))));
        return subs;
    }

    private Set<CheckStatusDTO> getBlockedStatuses(Set<SubscriptionDTO> subscriptions) {
        return dataServiceClient.checkStatus(subscriptions.stream()
                .map(CheckStatusDTO::new)
                .collect(Collectors.toSet()))
                .stream()
                .filter(CheckStatusDTO::getStatus)
                .collect(Collectors.toSet());
    }
}
