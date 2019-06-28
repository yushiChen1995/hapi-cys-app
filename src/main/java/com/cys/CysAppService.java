package com.cys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cys
 * @date 2019/6/28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CysAppService {
    public static void main(String[] args) {
        SpringApplication.run(CysAppService.class, args);
    }
}
