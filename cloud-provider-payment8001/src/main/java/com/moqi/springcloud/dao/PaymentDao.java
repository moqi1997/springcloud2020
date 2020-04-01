package com.moqi.springcloud.dao;

import com.moqi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author moqi
 * @date 2020/4/1 14:54
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
