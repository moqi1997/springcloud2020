package com.moqi.springcloud.service;

import com.moqi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author moqi
 * @date 2020/4/1 15:19
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
