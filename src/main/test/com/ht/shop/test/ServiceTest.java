package com.ht.shop.test;

import com.ht.shop.entity.Area;
import com.ht.shop.entity.Shop;
import com.ht.shop.entity.vo.ShopVo;
import com.ht.shop.service.AreaService;
import com.ht.shop.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceTest extends BaseTest {

    @Autowired
    AreaService areaService;

    @Autowired
    ShopService shopService;

    @Test
    public void getAreaList(){
        List<Area> areaList = areaService.getAreaList();

        System.out.println(areaList);
    }

    @Test
    public void getShopByIdTest(){
        ShopVo shopById = shopService.getShopById(1 + "");

        System.out.println(shopById);
    }

    @Test
    public void getShopListTest(){
        Shop shopCondition = new Shop();
        shopCondition.setUserId("1");
        List<Shop> shopList = shopService.getShopList(1, 10, shopCondition);

        System.out.println(shopList);
    }
}
