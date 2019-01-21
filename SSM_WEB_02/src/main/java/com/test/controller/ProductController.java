package com.test.controller;

import com.test.pojo.Pagebean;
import com.test.pojo.Product;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // 查询所有
    @RequestMapping("queryAllProductList")
    public String findAllProduct(Model model) {
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList", productList);
        return "product-list";
    }

    // 跳转到商品添加页面
    @RequestMapping("toAddProductPage")
    public String toAddProductPage() {
        return "product-add";
    }

    // 添加商品
    @RequestMapping("addProduct")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/product/queryProductListByPageHelper";
//        return "redirect:/product/queryAllProductList";
    }

    // 跳转到修改页面
    @RequestMapping("toUpdateProductPage")
    public String toUpdateProductPage(Long id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    // 修改商品信息
    @RequestMapping("updateProduct")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/product/queryProductListByPageHelper";
//        return "redirect:/product/queryAllProductList";
    }

    // 查询分页显示数据
    @RequestMapping("queryPageBean")
    public String queryPageBean(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "numPerPage", defaultValue = "5") int numPerPage,
            Model model) {

        // 1.调用业务层 查询分页显示数据
        Pagebean<Product> pageBean = productService.queryPageData(pageNum, numPerPage);
        // 2.将分页bean传给页面
        model.addAttribute("pageBean", pageBean);
        // 3.返回视图
        return "product-list";
    }

    // 使用分页助手 查询分页显示数据
    @RequestMapping("queryProductListByPageHelper")
    public String queryProductListByPageHelper(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                     @RequestParam(value = "numPerPage", defaultValue = "5") int numPerPage,
                                               Model model) {

        // 调用业务层 查询分页数据
        Pagebean<Product> pageBean = productService.queryPageData(pageNum, numPerPage);
        // 将数据放到model中,在前端显示
        model.addAttribute("pageBean",pageBean);
        return "product-list";
    }

    @RequestMapping("deleteProduct")
    public String deleteProduct(@RequestParam("id") List<Long> idList) {
        productService.deleteProduct(idList);
        return "redirect:/product/queryProductListByPageHelper";
//        return "redirect:/product/queryAllProductList";
    }
}
