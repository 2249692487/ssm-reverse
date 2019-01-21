package com.test.service;

import com.test.pojo.Pagebean;
import com.test.pojo.Product;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
public interface ProductService {
    List<Product> findAllProduct();

    void addProduct(Product product);

    Product findProductById(Long id);

    void updateProduct(Product product);

    Pagebean<Product> queryPageData(int pageNum, int numPerPage);

    Pagebean<Product> queryProductListByPageHelper(int pageNum, int numPerPage);

    void deleteProduct(List<Long> idList);
}
