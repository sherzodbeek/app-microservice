package uz.pdp.appticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppTicketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTicketServiceApplication.class, args);
    }

}
