package com.ht.shop.entity.vo;

import com.ht.shop.entity.Area;
import com.ht.shop.entity.PersonInfo;
import com.ht.shop.entity.Shop;
import com.ht.shop.entity.ShopCategory;

public class ShopVo extends Shop {

    private Area area;

    private ShopCategory shopCategory;

    private PersonInfo personInfo;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
