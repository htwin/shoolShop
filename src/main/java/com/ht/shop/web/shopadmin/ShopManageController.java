package com.ht.shop.web.shopadmin;

import com.alibaba.fastjson.JSONObject;
import com.ht.shop.common.enums.CommonEnum;
import com.ht.shop.common.response.ResponseResult;
import com.ht.shop.common.util.ImageUtil;
import com.ht.shop.entity.Shop;
import com.ht.shop.entity.vo.ShopVo;
import com.ht.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shopadmin")
public class ShopManageController {

    @Autowired
    ShopService shopService;

    @RequestMapping("/shopoperation")
    public String shopOperation(){
        return "/shop/shop_operation";
    }
    @RequestMapping("/shopList")
    public String shopList(){
        return "/shop/shop_list";
    }
    @RequestMapping("/shopManage")
    public String shopManage(){
        return "/shop/shop_manage";
    }

    @RequestMapping("/productCategoryManage")
    public String productCategory(){
        return "/shop/productCategory";
    }
    @RequestMapping("/productList")
    public String productList(){
        return "/shop/product_list";
    }
    @RequestMapping("/productAddOrUpdate")
    public String productAddOrUpdate(){
        return "/shop/productAddOrUpdate";
    }


    @ResponseBody
    @RequestMapping(value = "/getShopById",method = RequestMethod.GET)
    public ResponseResult getShopById(String shopId){
        ShopVo shopVo = shopService.getShopById(shopId);
        if(shopVo == null){
            return new ResponseResult(CommonEnum.FAIL);
        }
        return new ResponseResult(CommonEnum.SUCCESS,shopVo);
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseResult update(MultipartFile imgFile, HttpServletRequest request) throws IOException {
        //获取json字符串参数
        String shopStr = request.getParameter("shopStr");

        //json字符串转对象
        Shop shop = JSONObject.parseObject(shopStr,Shop.class);


        //保存图片 并返回路径
        String imgPath = "";
        if(imgFile != null){
            imgPath = ImageUtil.generateThumbnail(imgFile);
            shop.setShopImg(imgPath);
        }
        shop.setLastEditTime(new Date());
        int update = shopService.update(shop);
        if(update>0){
            return new ResponseResult(CommonEnum.SUCCESS,shop);
        }else{
            return new ResponseResult(CommonEnum.FAIL);
        }
    }

    @ResponseBody
    @RequestMapping("/getShopList")
    public ResponseResult getShopList(Integer page,Integer size,Shop shopCondition){

        if(shopCondition==null){
            shopCondition = new Shop();

        }
        shopCondition.setUserId("1");

        if(page==null||page<1){
            page = 1;
        }
        if(size==null||size<0){
            size = 10;
        }
        try {
            List<Shop> shopList = shopService.getShopList(page, size, shopCondition);
            return new ResponseResult(CommonEnum.SUCCESS,shopList);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.GETSHOPLISTERROR);
        }
    }





}
