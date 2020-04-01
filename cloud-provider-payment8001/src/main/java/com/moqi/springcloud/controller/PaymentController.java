package com.moqi.springcloud.controller;

import com.moqi.springcloud.entities.CommonResult;
import com.moqi.springcloud.entities.Payment;
import com.moqi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author moqi
 * @date 2020/4/1 15:22
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult insert(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("******查询结果：" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询数据成功", paymentById);
        } else {
            return new CommonResult(444, "查询数据失败", null);
        }
    }

}
