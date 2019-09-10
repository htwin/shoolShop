package com.ht.shop.mapper;

import com.ht.shop.entity.HeadLine;

import java.util.List;

public interface HeadLineMapper {
    //选择优先级最高的三条
    List<HeadLine> selectHeadLineList();
}
