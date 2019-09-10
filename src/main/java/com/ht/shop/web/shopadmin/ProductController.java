package com.ht.shop.web.shopadmin;

import com.alibaba.fastjson.JSONObject;
import com.ht.shop.common.enums.CommonEnum;
import com.ht.shop.common.response.ResponseResult;
import com.ht.shop.common.util.IdUtil;
import com.ht.shop.common.util.ImageUtil;
import com.ht.shop.entity.Product;
import com.ht.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shopadmin")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/findProductListByShopId")
    @ResponseBody
    public ResponseResult findProductListByShopId(String shopId) {
        try {
            List<Product> productList = productService.findProductListByShopId(shopId);
            if (productList == null) {
                return new ResponseResult(CommonEnum.NOPRODUCT);
            }
            return new ResponseResult(CommonEnum.SUCCESS, productList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }

    }

    @RequestMapping("/addProduct")
    @ResponseBody
    public ResponseResult addProduct(MultipartFile imgFile, HttpServletRequest request) {
        try {
            String productStr = request.getParameter("product");

            Product product = JSONObject.parseObject(productStr, Product.class);
            String thumbnail = "";
            if (imgFile != null) {
                thumbnail = ImageUtil.generateThumbnail(imgFile);
                product.setThumbnail(thumbnail);
            }

            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            product.setEnableStatus(0);//0下架 1上架
            product.setProductId(IdUtil.getId());


            int i = productService.addProduct(product);
            if (i < 1) {
                return new ResponseResult(CommonEnum.FAIL);
            }
            return new ResponseResult(CommonEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }

    }

    @RequestMapping("/getProductById")
    @ResponseBody
    public ResponseResult getProductById(String productId) {
        try{
            Product product = productService.findProductByProductId(productId);

            if(product == null){
                return new ResponseResult(CommonEnum.FAIL);
            }
            return new ResponseResult(CommonEnum.SUCCESS,product);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }


    }

    @RequestMapping("/updateProduct")
    @ResponseBody
    public ResponseResult updateProduct(MultipartFile imgFile, HttpServletRequest request) {

        try {
            //update
            String productStr = request.getParameter("product");

            Product product = JSONObject.parseObject(productStr, Product.class);

            String thumbnail = "";
            if (imgFile != null) {
                thumbnail = ImageUtil.generateThumbnail(imgFile);
                product.setThumbnail(thumbnail);
            }
            product.setLastEditTime(new Date());


            int i = productService.updateProduct(product);
            if (i < 1) {
                return new ResponseResult(CommonEnum.FAIL);
            }
            return new ResponseResult(CommonEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }

    }

}
