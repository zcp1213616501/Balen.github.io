package com.mashibing.cloudalibabaseataorder8801.service.impl;

import com.mashibing.cloudalibabaseataorder8801.client.StockClient;
import com.mashibing.cloudalibabaseataorder8801.service.OrderService;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private StockClient stockClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GlobalTransactional//全局事务开启
    @Override
    public void create() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("seata-stock");
        //System.err.println(serviceInstance.getInstanceId());
        //System.out.println(RootContext.getXID());
        // 减库存
        stockClient.decrement();

        // 添加异常
        //int i = 1/0;

        // 创建订单
        jdbcTemplate.update("insert into order_at (count) values (1)");
    }
}
