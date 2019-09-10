package com.ht.shop.web.superadmin;

import com.ht.shop.entity.ShopCategory;
import com.ht.shop.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class ShopCategoryController {

    @Autowired
    private ShopCategoryService shopCategoryService;

    @RequestMapping(value = "/getSubCategoryList",method = RequestMethod.GET)
    public List<ShopCategory> getSubCategoryList(){
        return shopCategoryService.getSubCategoryList();
    }

}
