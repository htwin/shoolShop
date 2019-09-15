package com.ht.shop.web.shopfront;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopfront")
public class RouterController {
    @RequestMapping("/index")
    public String index(){
        return "/shopfront/index";
    }

    @RequestMapping("/shopList")
    public String shopList(){
        return "/shopfront/shop_list";
    }
}
