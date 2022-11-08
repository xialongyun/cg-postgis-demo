package com.x.service;

import com.alibaba.fastjson.JSONObject;
import com.x.entity.Population;
import com.baomidou.mybatisplus.extension.service.IService;
import com.x.mapper.PopulationMapper;

import java.math.BigInteger;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
public interface PopulationService extends IService<Population> {
    BigInteger countPopulation(String s);
}
