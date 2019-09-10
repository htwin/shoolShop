package com.ht.shop.web;

import com.alibaba.fastjson.JSONObject;
import com.ht.shop.common.enums.CommonEnum;
import com.ht.shop.common.response.ResponseResult;
import com.ht.shop.entity.Shop;
import com.ht.shop.service.ShopService;
import com.ht.shop.common.util.IdUtil;
import com.ht.shop.common.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseResult doRegister(MultipartFile imgFile, HttpServletRequest request) throws IOException {

        //获取json字符串参数
        String shopStr = request.getParameter("shopStr");

        //json字符串转对象
        Shop shop = JSONObject.parseObject(shopStr,Shop.class);

        //保存图片 并返回路径
        String imgPath = "";
        if(imgFile == null){
            imgPath = "/shop/default.jpg";
        }else{
            imgPath = ImageUtil.generateThumbnail(imgFile);
        }

        shop.setShopImg(imgPath);

        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setShopId(IdUtil.getId());
        shop.setUserId(1+"");
        int i = shopService.doRegister(shop);
        if(i>0){
            return new ResponseResult(CommonEnum.SUCCESS,shop);
        }else{
            return new ResponseResult(CommonEnum.FAIL);
        }
    }


}
