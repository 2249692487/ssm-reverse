package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.mapper.ProductMapper;
import com.test.pojo.Pagebean;
import com.test.pojo.Product;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.findProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public Pagebean<Product> queryPageData(int pageNum, int numPerPage) {
        Pagebean<Product> pagebean = new Pagebean<Product>();

        // 1 设置当前页码
        pagebean.setPageNum(pageNum);
        // 2 设置每页显示
        pagebean.setNumPerPage(numPerPage);
        // 3 设置分页显示数据
        // -- 查询数据库 : select * from product limit 开始索引,每页显示条数
        int start = (pageNum - 1) * numPerPage;
        List<Product> productList = productMapper.queryPageData(start, numPerPage);
        pagebean.setPagedata(productList);
        // 4 设置总记录数
        // -- 查询数据库: select count(*) from product
        Long totalCount = productMapper.queryTotalCount();
        pagebean.setTotalCount(totalCount);
        // 5 设置总页数
        // 总页数 = (总记录数 - 1) / 每页显示条数
        Long totalPage = (totalCount + numPerPage - 1) / numPerPage;
        pagebean.setTotalPage(totalPage.intValue());
        return pagebean;
    }

    @Override
    public Pagebean<Product> queryProductListByPageHelper(int pageNum, int numPerPage) {
        PageHelper.startPage(pageNum, numPerPage);
        List<Product> productList = productMapper.findAllProduct();
        Pagebean<Product> pageInfo = new Pagebean<Product>(productList);
        return pageInfo;
    }

    @Override
    public void deleteProduct(List<Long> idList) {
        productMapper.deleteProduct(idList);
    }
}
