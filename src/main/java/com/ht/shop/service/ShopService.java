package com.ht.shop.service;

import com.ht.shop.entity.Shop;
import com.ht.shop.entity.vo.ShopVo;

import java.util.List;

public interface ShopService {

    int doRegister(Shop shop);

    int update(Shop shop);

    ShopVo getShopById(String shopId);

    List<Shop> getShopList(Integer page,Integer size,Shop shopCondition);
}
