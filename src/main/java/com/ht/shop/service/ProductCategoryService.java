package com.ht.shop.service;

import com.ht.shop.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getProductCategoryListByShopId(String shopId);

    void addCategory(List<ProductCategory> productCategoryList);

    int deleteCategoryById(String productCategoryId);

}
