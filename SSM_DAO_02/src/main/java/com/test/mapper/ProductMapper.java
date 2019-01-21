package com.test.mapper;

import com.test.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
public interface ProductMapper {
    List<Product> findAllProduct();

    void addProduct(Product product);

    Product findProductById(@Param("id") Long id);

    void updateProduct(Product product);

    // 每页显示的条数
    List<Product> queryPageData(@Param("start") int start,@Param("numPerPage") int numPerPage);
    // 总条数
    Long queryTotalCount();

    void deleteProduct(@Param("idList") List<Long> idList);
}
