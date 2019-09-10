package com.ht.shop.mapper;

import com.ht.shop.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    List<Product> selectAll();

    int insert(@Param("product") Product product);

    int update(Product product);

    List<Product> selectProductListByShopId(@Param("shopId") String shopId);
    Product selectProductByProductId(@Param("productId") String productId);
}
