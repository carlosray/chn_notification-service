package ru.vas.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"value", "type"})
public class CheckStatusDTO {
    private String value;
    private SubscriptionDTO.Type type;
    private Boolean status;

    public CheckStatusDTO(SubscriptionDTO subscription) {
        this.value = subscription.getValue();
        this.type = subscription.getType();
    }

}
