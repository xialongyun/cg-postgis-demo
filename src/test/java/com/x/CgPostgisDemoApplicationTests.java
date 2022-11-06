package com.x;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x.entity.Market;
import com.x.entity.Population;
import com.x.mapper.MarketMapper;
import com.x.mapper.NycBuildingsMapper;
import com.x.mapper.PopulationMapper;
import com.x.mapper.SpatialRefSysMapper;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
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
    void contextLoads() throws ParseException, IOException {

        QueryWrapper<Market> queryWrapper = new QueryWrapper<>();
        //List<Market> l = marketMapper.selectByGid(1);
        String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";

        //List<Market> l = marketMapper.selectMarketByGeoJson(s);
        //l.forEach(System.out::println);
        System.out.println(marketMapper.countMarketNumByGeoJson(s));
        System.out.println(populationMapper.countPopulationByGeoJson(s));

        List<Population> l = populationMapper.selectPopulationByGeoJson(s);
        l.forEach(System.out::println);
//
//        String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";
//        queryWrapper.eq("the_geom", );
        //List<Market> l = marketMapper.selectList(queryWrapper);
        //l.forEach(System.out::println);

//        QueryWrapper<Population> queryWrapper = new QueryWrapper<>();
//
//        queryWrapper.eq("gid", 1001);
//        List<Population> l = populationMapper.selectList(queryWrapper);
//        l.forEach(System.out::println);

//        WBK2GeoJsonTypeHandler wbk2GeoJsonTypeHandler = new WBK2GeoJsonTypeHandler();
//        wbk2GeoJsonTypeHandler.WBK2GeoJson();
//        Json2WBKTypeHandler json2WBKTypeHandler = new Json2WBKTypeHandler();
//
//        Json2GeomTypeHandler json2GeomTypeHandler = new Json2GeomTypeHandler();
       // String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";
//        //System.out.println(json2GeomTypeHandler.json2Geom(s));
//
//        System.out.println(Json2WBKTypeHandler.json2WBK(s));

        //System.out.println(Convert.wkt2Geom(s).toString());
    }

}
