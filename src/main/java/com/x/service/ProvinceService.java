package com.x.service;

import com.alibaba.fastjson.JSONObject;
import com.x.entity.Province;
import com.baomidou.mybatisplus.extension.service.IService;
import com.x.mapper.ProvinceMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author X
 * @since 2022-11-07
 */

public interface ProvinceService extends IService<Province> {
    List<Province> queryAllProvinces();
}
