package com.x;

import com.x.mapper.MarketMapper;
import com.x.mapper.NycBuildingsMapper;
import com.x.mapper.PopulationMapper;
import com.x.mapper.SpatialRefSysMapper;
import com.x.utils.typehandler.Json2GeomTypeHandler;
import com.x.utils.typehandler.WBK2GeoJsonTypeHandler;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

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
    void contextLoads() throws ParseException, IOException {

//        QueryWrapper<Market> queryWrapper = new QueryWrapper<>();
//
//        queryWrapper.eq("gid", 1);
//        List<Market> l = marketMapper.selectList(queryWrapper);
//        l.forEach(System.out::println);

//        QueryWrapper<Population> queryWrapper = new QueryWrapper<>();
//
//        queryWrapper.eq("gid", 1001);
//        List<Population> l = populationMapper.selectList(queryWrapper);
//        l.forEach(System.out::println);

//        WBK2GeoJsonTypeHandler wbk2GeoJsonTypeHandler = new WBK2GeoJsonTypeHandler();
//        wbk2GeoJsonTypeHandler.WBK2GeoJson();

        Json2GeomTypeHandler json2GeomTypeHandler = new Json2GeomTypeHandler();
        String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";
        System.out.println(json2GeomTypeHandler.json2Geom(s));


    }

}
