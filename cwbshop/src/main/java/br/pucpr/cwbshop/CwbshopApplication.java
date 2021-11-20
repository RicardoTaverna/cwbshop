package br.pucpr.cwbshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CwbshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwbshopApplication.class, args);
    }

}
