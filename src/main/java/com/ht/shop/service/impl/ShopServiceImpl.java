package com.ht.shop.service.impl;

import com.ht.shop.entity.Shop;
import com.ht.shop.entity.vo.ShopVo;
import com.ht.shop.mapper.ShopMapper;
import com.ht.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    public int doRegister(Shop shop) {
        return shopMapper.insertShop(shop);
    }

    public int update(Shop shop) {

        return shopMapper.updateShop(shop);
    }

    public ShopVo getShopById(String shopId) {
        return shopMapper.selectShopById(shopId);
    }

    public List<Shop> getShopList(Integer page, Integer size, Shop shopCondition) {
        return shopMapper.selectShopList(page,size,shopCondition);
    }
}
