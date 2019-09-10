package com.ht.shop.mapper;

import com.ht.shop.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryMapper {

    List<ProductCategory> getProductCategoryByShopId(@Param("shopId") String shopId);

    int insert(@Param("productCategory") ProductCategory productCategory);

    int deleteById(@Param("productCategoryId") String productCategoryId);

}
