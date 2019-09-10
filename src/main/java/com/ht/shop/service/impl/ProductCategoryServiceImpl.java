package com.ht.shop.service.impl;

import com.ht.shop.entity.ProductCategory;
import com.ht.shop.mapper.ProductCategoryMapper;
import com.ht.shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    public List<ProductCategory> getProductCategoryListByShopId(String shopId) {
        return productCategoryMapper.getProductCategoryByShopId(shopId);
    }

    public void addCategory(List<ProductCategory> productCategoryList) {
        for (ProductCategory productCategory:productCategoryList) {
             productCategoryMapper.insert(productCategory);
        }

    }

    public int deleteCategoryById(String productCategoryId) {
        return productCategoryMapper.deleteById(productCategoryId);
    }
}
