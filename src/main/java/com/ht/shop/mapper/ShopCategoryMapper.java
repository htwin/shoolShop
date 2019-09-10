package com.ht.shop.mapper;

import com.ht.shop.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryMapper {

    /**
     * 获取所有子分类列表
     * @return
     */
    List<ShopCategory> selectAllSubCategory();

    /**
     * 获取所有父分类  parentId = 0
     */

    List<ShopCategory> selectAllParentCategory();

}
