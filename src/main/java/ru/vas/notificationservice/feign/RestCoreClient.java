package ru.vas.notificationservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vas.notificationservice.dto.SubscriptionDTO;

import java.util.Set;

@FeignClient("rest-core")
public interface RestCoreClient {

    @GetMapping("service/subs/all")
    Set<SubscriptionDTO> getAllSubscriptions();

}
