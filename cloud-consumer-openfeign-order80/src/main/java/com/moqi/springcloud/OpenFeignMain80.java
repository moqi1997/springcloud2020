package com.moqi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author moqi
 * @date 2020/4/6 19:48
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class,args);
    }
}
