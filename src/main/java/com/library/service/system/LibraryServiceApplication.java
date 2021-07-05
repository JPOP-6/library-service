package com.library.service.system;

import com.library.service.system.config.KafkaConsumerConfiguration;
import com.library.service.system.kafkalistener.KafkaListener;
import com.library.service.system.repositories.LibraryRepository;
import com.library.service.system.service.BookFallbackService;
import com.library.service.system.service.LibraryService;
import com.library.service.system.service.UserFallbackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
        LibraryRepository.class
})
@EntityScan("com.library.service.system.model")
@Import(value = {
        LibraryService.class,
        BookFallbackService.class,
        UserFallbackService.class,
        KafkaConsumerConfiguration.class,
        KafkaListener.class
})
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class LibraryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryServiceApplication.class, args);
    }

}
