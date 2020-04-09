package com.moqi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author moqi
 * @date 2020/4/9 10:03
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashMain9001.class,args);
    }
}
