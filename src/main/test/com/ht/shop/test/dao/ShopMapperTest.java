package com.ht.shop.test.dao;

import com.ht.shop.entity.*;
import com.ht.shop.mapper.HeadLineMapper;
import com.ht.shop.mapper.ShopCategoryMapper;
import com.ht.shop.mapper.ShopMapper;
import com.ht.shop.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ShopMapperTest extends BaseTest {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Test
    public void headLineMapperTest(){
        List<ShopCategory> shopCategories = shopCategoryMapper.selectAllParentCategory();

        System.out.println(shopCategories);



    }

    @Test
    public void insertShopTest(){


        Shop shop = new Shop();
        Area area = new Area();
        area.setAreaId(1);
        PersonInfo owner = new PersonInfo();
       // owner.setUserId(1l);

        ShopCategory shopCategory = new ShopCategory();
        //shopCategory.setShopCategoryId(1l);

        shop.setShopName("测试商铺002");
       // shop.setArea(area);
        //shop.setOwner(owner);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");
        shop.setEnableStatus(0);
        shop.setPhone("15196262883");
        shop.setShopAddr("三栋");
        shop.setPriority(100);
        //shop.setShopCategory(shopCategory);

        int i = shopMapper.insertShop(shop);

        System.out.println(i);

    }

    @Test
    public void getShopByIdTest(){

    }

    @Test
    public void updateShopTest(){


        Shop shop = new Shop();
        //shop.setShopId(1l);
        Area area = new Area();
        area.setAreaId(1);
        PersonInfo owner = new PersonInfo();
       // owner.setUserId(1l);

        ShopCategory shopCategory = new ShopCategory();
        //shopCategory.setShopCategoryId(1l);
        shop.setShopName("测试商铺001修改");
       // shop.setArea(area);
       // shop.setOwner(owner);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");
        shop.setEnableStatus(0);
        shop.setPhone("15196262883");
        shop.setShopAddr("三栋");
        shop.setPriority(100);
       // shop.setShopCategory(shopCategory);
        int i = shopMapper.updateShop(shop);
        System.out.println(i);

    }

}
