package com.ht.shop.service.impl;

import com.ht.shop.entity.ShopCategory;
import com.ht.shop.mapper.ShopCategoryMapper;
import com.ht.shop.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;


    public List<ShopCategory> getSubCategoryList() {

        return shopCategoryMapper.selectAllSubCategory();
    }

    public List<ShopCategory> getAllParentCategoryList() {

        return shopCategoryMapper.selectAllParentCategory();
    }
}
