package com.mashibing.cloudalibabaseatastock8802.service.impl;


import com.mashibing.cloudalibabaseatastock8802.service.StockService;
import io.seata.core.context.RootContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void decr() {
        jdbcTemplate.update("update stock set count = count - 1 where product_id = 1");
    }
}
