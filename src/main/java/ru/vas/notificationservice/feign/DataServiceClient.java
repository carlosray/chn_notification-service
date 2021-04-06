package ru.vas.notificationservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vas.notificationservice.dto.CheckStatusDTO;

import java.util.Set;

@FeignClient("data-service")
public interface DataServiceClient {
    @GetMapping("api/blocked/search/ip/status")
    Set<CheckStatusDTO> checkStatus(Set<CheckStatusDTO> checkStatus);
}
