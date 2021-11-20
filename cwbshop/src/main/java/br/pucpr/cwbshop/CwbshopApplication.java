package br.pucpr.cwbshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The type Cwbshop application.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CwbshopApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CwbshopApplication.class, args);
    }

}
