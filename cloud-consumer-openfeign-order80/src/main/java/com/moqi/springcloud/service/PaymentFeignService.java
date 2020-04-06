package com.moqi.springcloud.service;

import com.moqi.springcloud.entities.CommonResult;
import com.moqi.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author moqi
 * @date 2020/4/6 19:51
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
