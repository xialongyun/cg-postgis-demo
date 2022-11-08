package com.x.controller;

import com.alibaba.fastjson.JSONObject;
import com.x.mapper.MarketMapper;
import com.x.mapper.PopulationMapper;
import com.x.service.impl.MarketServiceImpl;
import com.x.service.impl.PopulationServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/market")
public class MarketController {
    @Autowired
    MarketMapper marketMapper;

    @Autowired
    PopulationMapper populationMapper;

    /**
     * 查询该区域内有多少市场
     * @param geoJson 地理范围
     * @return 市场
     */
    @PostMapping(value = "/queryMarketNum")
    public Integer queryMarketNum(@RequestBody String geoJson) {
        MarketServiceImpl marketService = new MarketServiceImpl(marketMapper);
        return marketService.countMarket(geoJson);
    }

    /**
     * 查询该区域内有多少人口和市场
     * @param geoJson 地理范围
     * @return 人口和市场
     */
    @PostMapping(value = "/queryMarketAndPopulation")
    public JSONObject queryMarketAndPopulation(@RequestBody String geoJson) {
        PopulationServiceImpl populationService = new PopulationServiceImpl(populationMapper);
        MarketServiceImpl marketService = new MarketServiceImpl(marketMapper);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("market", marketService.countMarket(geoJson));
        jsonObject.put("population", populationService.countPopulation(geoJson));
        return jsonObject;
    }
}
