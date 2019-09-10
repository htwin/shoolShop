package com.ht.shop.web.shopfront;

import com.ht.shop.common.enums.CommonEnum;
import com.ht.shop.common.response.ResponseResult;
import com.ht.shop.entity.HeadLine;
import com.ht.shop.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/shopfront")
public class HeadLineController {

    @Autowired
    private HeadLineService headLineService;

    @ResponseBody
    @RequestMapping(value = "/getHeadLineList",method = RequestMethod.GET)
    public ResponseResult getHeadLineList(){
        try{
            List<HeadLine> headLineList = headLineService.findHeadLineList();

            return new ResponseResult(CommonEnum.SUCCESS,headLineList);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(CommonEnum.FAIL);
        }
    }

}
