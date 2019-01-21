package com.test.mapper;

import com.test.pojo.Orders;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/13
 */
public interface OrderMapper {
    // 查询所有
    List<Orders> queryAllOrdersList();

    void addOrders(Orders orders);
}
