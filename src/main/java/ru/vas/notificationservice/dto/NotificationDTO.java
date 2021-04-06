package ru.vas.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vas.notificationservice.model.Notification;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO implements Serializable {
    private UserBaseDTO user;
    private Map<Notification, Set<SubscriptionDTO>> subs;

    public NotificationDTO(Map.Entry<UserBaseDTO, Set<SubscriptionDTO>> entry) {
        this.user = entry.getKey();
        this.subs = entry.getValue().stream()
                .collect(Collectors.groupingBy(SubscriptionDTO::getNotification, Collectors.toSet()));
    }
}
