package com.x.service.impl;

import com.x.entity.Population;
import com.x.mapper.PopulationMapper;
import com.x.service.PopulationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public void insertBatch(String feature) {

    }

    public static void main(String[] args) {

    }
}
