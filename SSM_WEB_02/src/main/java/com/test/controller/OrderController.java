package com.test.controller;

import com.test.pojo.Orders;
import com.test.pojo.Product;
import com.test.service.OrdersService;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/13
 */
@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;

    @RequestMapping("queryAllOrdersList")
    public String queryAllOrdersList(Model model) {
        List<Orders> ordersList = ordersService.queryAllOrdersList();
        model.addAttribute("ordersList", ordersList);
        return "order-list";
    }

    // 跳转到添加界面
    @RequestMapping("toAddOrdersPage")
    public String toAddOrdersPage(Model model) {
        List<Product> allProduct = productService.findAllProduct();
        model.addAttribute("plist", allProduct);
        return "order-add";
    }

    // 添加
    @RequestMapping("addOrders")
    public String addOrders(Orders orders) {
        ordersService.addOrders(orders);
        return "redirect:/orders/queryAllOrdersList";
    }


}
