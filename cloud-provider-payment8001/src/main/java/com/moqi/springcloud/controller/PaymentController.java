package com.moqi.springcloud.controller;

import com.moqi.springcloud.entities.CommonResult;
import com.moqi.springcloud.entities.Payment;
import com.moqi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author moqi
 * @date 2020/4/1 15:22
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result + "O(∩_∩)O哈哈~");
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult insert(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("******查询结果：" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询数据成功serverPort:" + serverPort, paymentById);
        } else {
            return new CommonResult(444, "查询数据失败", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> service = discoveryClient.getServices();
        for (String element : service) {
            log.info("*****element: " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
