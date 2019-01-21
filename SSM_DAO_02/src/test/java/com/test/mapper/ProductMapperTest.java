package com.test.mapper;

import com.github.pagehelper.PageHelper;
import com.test.pojo.Pagebean;
import com.test.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext_dao.xml")
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void demo1() {
        // 需求: 查询所有的记录
        List<Product> productList = productMapper.findAllProduct();
        System.out.println("================== 总记录数: " + productList.size());
        for (Product product : productList) {
            System.out.println("==========================================");
            System.out.println(product);
        }
    }

    @Test
    public void demo2() {
        // 需求: 查询分页需要的数据
        // 1 使用分页助手: 第一个参数: 当前页码; 第二个参数: 每页显示条数
        PageHelper.startPage(2, 5);

        // 查询分页显示的数据
        List<Product> productList = productMapper.findAllProduct();
        System.out.println("================== 总记录数: " + productList.size());
        for (Product product : productList) {
            System.out.println("==========================================");
            System.out.println(product);
        }

        // 2. 查询分页其他的数据
        Pagebean<Product> pageInfo = new Pagebean<>(productList);
        // 2.1 查询当前页码
        int pageNum = pageInfo.getPageNum();
        System.out.println("=================== 当前页码 : " + pageNum);
        // 2.2 查询每页显示条数
        int pageSize = pageInfo.getPageNum();
        System.out.println("=================== 每页显示条数 : " + pageSize);

        // 2.3 查询总记录数
//        long total = pageInfo.getTotalCount();
        Long total = productMapper.queryTotalCount();
        System.out.println("=================== 总记录数: " + total);
        // 2.4 查询总页数
        int pages = pageInfo.getTotalPage();
        System.out.println("=================== 总页数: " + pages);

        // 2.5 查询分页显示数据
        List<Product> list = pageInfo.getPagedata();
        System.out.println("========= 分页显示数据: 大小 == " + list.size());
    }
}