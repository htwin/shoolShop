package com.ht.shop.web.superadmin;

import com.ht.shop.entity.Area;
import com.ht.shop.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    AreaService areaService;

    @RequestMapping("/list")
    public List<Area> getAreaList(){
        long startTime = System.currentTimeMillis();
        logger.info("===start===");



        List<Area> areaList = areaService.getAreaList();
        long endTime = System.currentTimeMillis();
        logger.error("test error");
        logger.debug("costTime:[{}ms]:",endTime-startTime);
        logger.info("===end===");
        return areaList;

    }

}
