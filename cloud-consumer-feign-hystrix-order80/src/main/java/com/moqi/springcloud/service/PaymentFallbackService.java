package com.moqi.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author moqi
 * @date 2020/4/8 10:14
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService  paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService  paymentInfo_TimeOut";
    }
}
