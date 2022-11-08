package com.x.service.impl;

import com.x.entity.Population;
import com.x.mapper.PopulationMapper;
import com.x.service.PopulationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
@Service
public class PopulationServiceImpl extends ServiceImpl<PopulationMapper, Population> implements PopulationService {
    @Autowired
    PopulationMapper populationMapper;

    public PopulationServiceImpl(PopulationMapper populationMapper) {
        this.populationMapper = populationMapper;
    }
    @Override
    public BigInteger countPopulation(String s) {
        return populationMapper.countPopulationByGeoJson(s);
    }
}
