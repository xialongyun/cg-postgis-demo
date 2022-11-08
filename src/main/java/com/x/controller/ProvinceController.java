package com.x.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.entity.Province;
import com.x.mapper.ProvinceMapper;
import com.x.service.impl.ProvinceServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author X
 * @since 2022-11-06
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    ProvinceMapper provinceMapper;

    @GetMapping("/getAllProvince")
    public JSONObject getAllProvince() {
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl(provinceMapper);
        List<Province> list = provinceService.queryAllProvinces();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Province province : list) {
            JSONObject p = new JSONObject();
            p.put("name",province.getName());
            p.put("areaId", province.getIndex() + 1);
            jsonArray.add(p);
        }
        result.put("country","中国");
        result.put("province",jsonArray);
        return result;
    }
}
