package ru.vas.notificationservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vas.notificationservice.dto.SubscriptionDTO;
import ru.vas.notificationservice.dto.UserBaseDTO;
import ru.vas.notificationservice.exception.SendNotificationException;
import ru.vas.notificationservice.service.SendService;

import java.util.Set;

@Service("mailSendService")
@Slf4j
public class MailSendService implements SendService {

    @Override
    public void send(UserBaseDTO user, Set<SubscriptionDTO> subs) throws SendNotificationException {
        log.info("Заглушка отправки уведомлений." + user.getEmail() + " Кол-во уведомлений: " + subs.size());
    }
}
