package com.test.service;

import com.test.pojo.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/13
 */

public interface OrdersService {
    List<Orders> queryAllOrdersList();

    void addOrders(Orders orders);
}
