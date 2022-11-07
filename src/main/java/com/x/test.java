package com.x;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x.entity.Market;
import com.x.mapper.MarketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class test {
//    @Autowired
//    static MarketMapper marketMapper;
//    private static test t;
//    @PostConstruct
//    private void init() {
//        t = this;
//        marketMapper = this.marketMapper;
//    }
//
//    public static void main(String... args){
//        QueryWrapper<Market> queryWrapper = new QueryWrapper<>();
//        String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";
//
//        List<Market> l = t.marketMapper.selectMarketByGeoJson(s);
//        l.forEach(System.out::println);
//    }
}
