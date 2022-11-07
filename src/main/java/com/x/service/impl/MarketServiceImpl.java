package com.x.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x.entity.Market;
import com.x.mapper.MarketMapper;
import com.x.service.MarketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
@Service
public class MarketServiceImpl extends ServiceImpl<MarketMapper, Market> implements MarketService {
    @Autowired
    static MarketMapper marketMapper;

    public static void main(String... args){
        QueryWrapper<Market> queryWrapper = new QueryWrapper<>();
        String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";

        List<Market> l = marketMapper.selectMarketByGeoJson(s);
        l.forEach(System.out::println);
    }
}
