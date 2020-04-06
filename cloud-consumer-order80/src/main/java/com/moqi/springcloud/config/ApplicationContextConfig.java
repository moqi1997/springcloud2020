package com.moqi.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author moqi
 * @date 2020/4/2 11:53
 */
@Configuration
public class ApplicationContextConfig {
    /**
    * applicationcontext.xml <bean id=" class=>
    * */
    @Bean
  //  @LoadBalanced
       public RestTemplate getRestTemplate() {
           return new RestTemplate();
       }
}
