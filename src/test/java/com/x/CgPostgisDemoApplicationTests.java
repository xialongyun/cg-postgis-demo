package com.x;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x.entity.Market;
import com.x.entity.Population;
import com.x.mapper.MarketMapper;
import com.x.mapper.NycBuildingsMapper;
import com.x.mapper.PopulationMapper;
import com.x.mapper.SpatialRefSysMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CgPostgisDemoApplicationTests {

    @Autowired
    MarketMapper marketMapper;
    @Autowired
    NycBuildingsMapper nycBuildingsMapper;
    @Autowired
    PopulationMapper populationMapper;
    @Autowired
    SpatialRefSysMapper spatialRefSysMapper;

    @Test
    void contextLoads() {

//        QueryWrapper<Market> queryWrapper = new QueryWrapper<>();
//
//        queryWrapper.eq("gid", 1);
//        List<Market> l = marketMapper.selectList(queryWrapper);
//        l.forEach(System.out::println);

        QueryWrapper<Population> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("gid", 1001);
        List<Population> l = populationMapper.selectList(queryWrapper);
        l.forEach(System.out::println);

    }

}
