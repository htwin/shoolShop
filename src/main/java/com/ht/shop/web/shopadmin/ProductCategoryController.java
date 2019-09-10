package com.ht.shop.web.shopadmin;

import com.ht.shop.common.enums.CommonEnum;
import com.ht.shop.common.response.ResponseResult;
import com.ht.shop.common.util.IdUtil;
import com.ht.shop.entity.ProductCategory;
import com.ht.shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryController {


    @Autowired
    ProductCategoryService productCategoryService;

    @ResponseBody
    @RequestMapping("/getProductCategoryListByShopId")
    public ResponseResult getProductCategoryListByShopId(String shopId){
        try {
            List<ProductCategory> categoryList = productCategoryService.getProductCategoryListByShopId(shopId);
            return new ResponseResult(CommonEnum.SUCCESS,categoryList);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }

    }

    @ResponseBody
    @RequestMapping("/addCategory")
    public ResponseResult addCategory(@RequestBody List<ProductCategory> productCategoryList){
        try {

            for(ProductCategory productCategory:productCategoryList){
                productCategory.setProductCategoryId(IdUtil.getId());
                productCategory.setCreateTime(new Date());
            }

            productCategoryService.addCategory(productCategoryList);
            return new ResponseResult(CommonEnum.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }

    }

    @ResponseBody
    @RequestMapping("/deleteCategoryById")
    public ResponseResult deleteCategoryById(String productCategoryId){
        try {
            int i = productCategoryService.deleteCategoryById(productCategoryId);
            if(i>0){
                return new ResponseResult(CommonEnum.SUCCESS);
            }else{
                return new ResponseResult(CommonEnum.FAIL);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }

    }

}
