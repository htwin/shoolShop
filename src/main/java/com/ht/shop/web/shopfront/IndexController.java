package com.ht.shop.web.shopfront;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shopfront")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "/shop/index";
    }

}
