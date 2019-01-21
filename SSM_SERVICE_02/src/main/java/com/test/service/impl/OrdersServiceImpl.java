package com.test.service.impl;

import com.test.mapper.OrderMapper;
import com.test.pojo.Orders;
import com.test.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/13
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> queryAllOrdersList() {
        return orderMapper.queryAllOrdersList();
    }

    @Override
    public void addOrders(Orders orders) {
        orderMapper.addOrders(orders);
    }
}
