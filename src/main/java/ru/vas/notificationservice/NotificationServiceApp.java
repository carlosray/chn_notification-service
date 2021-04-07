package ru.vas.notificationservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.vas.notificationservice.service.NotificationSender;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
@RequiredArgsConstructor
public class NotificationServiceApp implements ApplicationContextAware {
    private final NotificationSender notificationSender;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApp.class, args);
    }

    @Scheduled(cron = "${notification.interval}")
    public void notifications() {
        notificationSender.sendNotifications();
    }

    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        NotificationServiceApp.applicationContext = applicationContext;
    }
}
