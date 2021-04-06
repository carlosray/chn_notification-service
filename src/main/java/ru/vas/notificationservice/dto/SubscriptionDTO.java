package ru.vas.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.vas.notificationservice.model.Notification;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SubscriptionDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String value;
    private Type type;
    private Notification notification;
    private Boolean status;
    private UserBaseDTO user;

    public enum Type {
        IP,
        DOMAIN
    }
}
