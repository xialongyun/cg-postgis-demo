package com.x.service.impl;

import com.x.entity.Province;
import com.x.mapper.ProvinceMapper;
import com.x.service.ProvinceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author X
 * @since 2022-11-07
 */
@Service
@Component
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
    @Resource
    private ProvinceMapper provinceMapper;

    public ProvinceServiceImpl(ProvinceMapper provinceMapper) {
        this.provinceMapper = provinceMapper;
    }


    @Override
    public List<Province> queryAllProvinces() {
        List<Province> list = provinceMapper.queryAllProvinces();
        return list;
    }



}
