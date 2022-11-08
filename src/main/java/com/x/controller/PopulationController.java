package com.x.controller;

import com.x.mapper.PopulationMapper;
import com.x.service.impl.PopulationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/population")
public class PopulationController {
    @Autowired
    PopulationMapper populationMapper;

    /**
     * 查询该区域内有多少人口
     * @param geoJson 地理范围
     * @return 人口
     */
    @PostMapping(value = "/queryPopulation")
    public BigInteger queryPopulation(@RequestBody String geoJson) {
        PopulationServiceImpl populationService = new PopulationServiceImpl(populationMapper);
        return populationService.countPopulation(geoJson);
    }
}
