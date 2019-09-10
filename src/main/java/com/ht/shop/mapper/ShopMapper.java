package com.ht.shop.mapper;

import com.ht.shop.entity.PersonInfo;
import com.ht.shop.entity.Shop;
import com.ht.shop.entity.vo.ShopVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
    int insertShop(Shop shop);

    int updateShop(Shop shop);

    ShopVo selectShopById(String shopId);

    List<Shop> selectShopList(@Param("page") Integer page,@Param("size") Integer size,@Param("shopCondition") Shop shopCondition);
}
