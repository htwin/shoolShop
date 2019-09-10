package com.ht.shop.web.shopfront;

import com.ht.shop.common.enums.CommonEnum;
import com.ht.shop.common.response.ResponseResult;
import com.ht.shop.entity.ShopCategory;
import com.ht.shop.mapper.ShopCategoryMapper;
import com.ht.shop.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/shopfront")
public class ShopParentCategoryController {

    @Autowired
    private ShopCategoryService shopCategoryService;


    @ResponseBody
    @RequestMapping(value = "/getAllParentCategoryList",method = RequestMethod.GET)
    public ResponseResult getAllParentCategoryList(){

        try {
            List<ShopCategory> parentCategoryList = shopCategoryService.getAllParentCategoryList();
            return new ResponseResult(CommonEnum.SUCCESS,parentCategoryList);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }


    }


}
