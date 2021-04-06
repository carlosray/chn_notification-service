package ru.vas.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseDTO implements Serializable {
    private String email;
    private String firstName;
    private String lastName;
}
