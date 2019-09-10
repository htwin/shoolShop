package com.ht.shop.test.dao;

import com.ht.shop.entity.Area;
import com.ht.shop.mapper.AreaMapper;
import com.ht.shop.test.BaseTest;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class AreaMapperTest extends BaseTest {


    @Autowired
    AreaMapper areaMapper;

    @Test
    public void queryAreaList(){
        List<Area> areas = areaMapper.queryAreaList();

        System.out.println(areas);


    }
}
