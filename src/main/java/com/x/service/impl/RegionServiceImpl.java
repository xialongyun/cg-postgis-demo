package com.x.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.x.entity.Region;
import com.x.mapper.RegionMapper;
import com.x.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    public static final Integer[] pro_code = new Integer[]{
            110000, 120000, 130000, 140000, 150000, 210000, 220000, 230000, 310000, 320000, 330000,
            340000, 350000, 360000, 370000, 410000, 420000, 430000, 440000, 450000, 460000, 500000,
            510000, 520000,530000, 540000, 610000, 620000, 630000, 640000, 650000, 710000, 810000, 820000};

    public RegionServiceImpl(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    public Region queryRegionByAdcode(String tableName, Integer adcode) {
        return regionMapper.queryRegionByAdcode(tableName, adcode);
    }

    public Region queryRegionByName(String tableName, String name) {
        return regionMapper.queryRegionByName(tableName, name);
    }

    public List<Region> queryRegionList(String tableName, Integer adcode) {
        return regionMapper.queryRegionList(tableName, adcode);
    }
    public List<Region> queryRegionListByName(String tableName, String name) {
        return regionMapper.queryRegionListByName(tableName, name);
    }

    public Region queryPoint(String tableName, Double x, Double y) {
        return regionMapper.queryPoint(tableName, x, y);
    }
}
