package ru.vas.notificationservice.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vas.notificationservice.dto.SubscriptionDTO;
import ru.vas.notificationservice.service.SubscriptionService;

import java.util.Set;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ServiceController {
    private final SubscriptionService subscriptionService;

    @PostMapping("statuses")
    public ResponseEntity<Set<SubscriptionDTO>> checkStatuses(Set<SubscriptionDTO> subs) {
        return ResponseEntity.ok(subscriptionService.setStatuses(subs));
    }
}
