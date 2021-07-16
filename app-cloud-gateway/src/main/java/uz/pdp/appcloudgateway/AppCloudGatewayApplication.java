package uz.pdp.appcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppCloudGatewayApplication.class, args);
    }

}
