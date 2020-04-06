package com.moqi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author moqi
 * @date 2020/4/6 14:25
 */
@Component
public class MyLB implements LoadBalancer {
    //CAS 与 自旋锁
    private AtomicInteger atomicInteger = new AtomicInteger(0);
   public final int getAndIncrement() {
       int current;
       int next;
       do {
           current = this.atomicInteger.get();
           next = current >= 2147483647 ? 0 : current + 1;
       }while (!this.atomicInteger.compareAndSet(current,next));
       System.out.println("**********第几次访问次数next:" + next);
       return next;
   }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
       //第几次访问/服务器实例总数
       int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
