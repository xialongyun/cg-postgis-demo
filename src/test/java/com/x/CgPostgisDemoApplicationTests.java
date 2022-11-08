package com.x;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x.config.generator.InsertBatch;
import com.x.entity.Market;
import com.x.entity.Population;
import com.x.entity.Province;
import com.x.entity.Region;
import com.x.mapper.*;
import com.x.service.impl.CreateTableServiceImpl;
import com.x.service.impl.ProvinceServiceImpl;
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
    ProvinceMapper provinceMapper;

    @Autowired
    CreateTable createTable;

    @Autowired
    RegionMapper regionMapper;


    @Test
    void contextLoads() throws ParseException, IOException {
        String s = "{\"type\":Point,\"coordinates\":[126.47152,43.918785]}";
        System.out.println(regionMapper.queryPoint("province", Double.parseDouble("126.47152"), Double.parseDouble("43.918785")));
//        Region region = regionMapper.queryRegionByName("province", "吉林省");
//        System.out.println(region);
//        List<Province> l = provinceMapper.queryAllProvinces();
//        l.forEach(System.out::println);

//        CreateTableServiceImpl createTableService = new CreateTableServiceImpl(createTable);
//        createTableService.insertBatch();
//        QueryWrapper<Market> queryWrapper = new QueryWrapper<>();
//        List<Market> l = marketMapper.selectByGid(1);
//        String s = "{\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]],\"type\":\"Polygon\"}";
//
//        List<Market> l = marketMapper.selectMarketByGeoJson(s);
//       l.forEach(System.out::println);
//        System.out.println(marketMapper.countMarketNumByGeoJson(s));
//        System.out.println(populationMapper.countPopulationByGeoJson(s));
//
//        List<Population> l = populationMapper.selectPopulationByGeoJson(s);
//        l.forEach(System.out::println);
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
