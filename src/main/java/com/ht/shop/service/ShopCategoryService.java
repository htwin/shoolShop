package com.ht.shop.service;

import com.ht.shop.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    List<ShopCategory> getSubCategoryList();

    /**
     * 获取所有父分类
     * @return
     */
    List<ShopCategory> getAllParentCategoryList();
}
