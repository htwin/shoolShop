package com.ht.shop.service.impl;

import com.ht.shop.entity.HeadLine;
import com.ht.shop.mapper.HeadLineMapper;
import com.ht.shop.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {


    @Autowired
    private HeadLineMapper headLineMapper;
    public List<HeadLine> findHeadLineList() {
        return headLineMapper.selectHeadLineList();
    }
}
