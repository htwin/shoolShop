package com.ht.shop.service;

import com.ht.shop.entity.HeadLine;

import java.util.List;

public interface HeadLineService {

    /**
     * 查询优先级最高的三条
     * @return
     */
    List<HeadLine> findHeadLineList();

}
