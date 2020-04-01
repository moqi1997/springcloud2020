package com.moqi.springcloud.service.impl;

import com.moqi.springcloud.dao.PaymentDao;
import com.moqi.springcloud.entities.Payment;
import com.moqi.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author moqi
 * @date 2020/4/1 15:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
