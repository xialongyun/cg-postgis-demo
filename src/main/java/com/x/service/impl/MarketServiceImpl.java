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
    MarketMapper marketMapper;

    public MarketServiceImpl(MarketMapper marketMapper) {
        this.marketMapper = marketMapper;
    }

    /**
     * 输入地理范围GeoJson,查询该区域内有多少市场
     * @param s 区域GeoJson
     * @return 市场数量
     */
    @Override
    public Integer countMarket(String s) {
        return marketMapper.countMarketNumByGeoJson(s);
    }
}
