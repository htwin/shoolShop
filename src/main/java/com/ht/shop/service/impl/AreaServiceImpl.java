package com.ht.shop.service.impl;

import com.ht.shop.entity.Area;
import com.ht.shop.mapper.AreaMapper;
import com.ht.shop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    AreaMapper areaMapper;

    public List<Area> getAreaList() {
        return areaMapper.queryAreaList();
    }
}
