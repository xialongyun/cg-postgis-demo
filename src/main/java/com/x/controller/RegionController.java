package com.x.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.entity.Region;
import com.x.mapper.RegionMapper;
import com.x.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    RegionMapper regionMapper;

    /**
     * 各省、直辖市adcode
     */
    public static final Integer[] pro_code = new Integer[]{
            110000, 120000, 130000, 140000, 150000,
            210000, 220000, 230000,
            310000, 320000, 330000, 340000, 350000, 360000, 370000,
            410000, 420000, 430000, 440000, 450000, 460000,
            500000, 510000, 520000,530000, 540000,
            610000, 620000, 630000, 640000, 650000,
            710000,
            810000,
            820000};

    /**
     * 输入省或者市名称，能够查询该辖区下所有下级行政区划名字列表
     * @param name 省或者市名称
     * @return
     */
    @GetMapping("/queryRegion/{name}")
    public JSONObject queryRegion(@PathVariable String name) {
        RegionServiceImpl regionService = new RegionServiceImpl(regionMapper);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Region> list;
        Region province = regionService.queryRegionByName("province", name);

        if (province == null) {
            Region parent;
            for (Integer integer : pro_code) {
                parent = regionService.queryRegionByName("city_" + integer, name);
                if (parent != null) {
                    list = regionService.queryRegionList("district_" + parent.getAdcode(), parent.getAdcode());
                    for (Region region : list) {
                        JSONObject city = new JSONObject();
                        city.put("name", region.getName());
                        city.put("areaId", region.getIndex() + 1);
                        jsonArray.add(city);
                    }

                    jsonObject.put("distinct", jsonArray);
                    break;
                }
            }
        } else {
            jsonObject.put("province", province.getName());
            list = regionService.queryRegionList("city_" + province.getAdcode(), province.getAdcode());
            for (Region region : list) {
                JSONObject city = new JSONObject();
                city.put("name", region.getName());
                city.put("areaId", region.getIndex() + 1);
                jsonArray.add(city);
            }

            jsonObject.put("city", jsonArray);
        }

        return jsonObject;
    }

    /**
     * 查询点在哪个省市区
     * @param x 经度
     * @param y 纬度
     * @return
     */
    @GetMapping("/queryPoint")
    public JSONObject queryPoint(String x, String y) {
        RegionServiceImpl regionService = new RegionServiceImpl(regionMapper);

        JSONObject jsonObject = new JSONObject();
        Region pro = null;
        Region city = null;
        Region district = null;

        pro = regionService.queryPoint("province", Double.parseDouble(x), Double.parseDouble(y));
        String name = pro != null ? pro.getName() : "";
        if (pro != null && name.equals("台湾省")) {
            jsonObject.put("province", pro.getName());
        } else if (pro != null && (name.equals("北京市") || name.equals("上海市") || name.equals("天津市") || name.equals("重庆市") || name.equals("香港市") || name.equals("澳门市"))) {
            jsonObject.put("province", pro.getName());
            jsonObject.put("city", pro.getName() + "市辖区");
            district = regionService.queryPoint("district_"+pro.getAdcode(), Double.parseDouble(x), Double.parseDouble(y));
        } else if (pro != null) {
            jsonObject.put("province", pro.getName());
            city = regionService.queryPoint("city_" + pro.getAdcode(), Double.parseDouble(x), Double.parseDouble(y));
        }

        if (city != null) {
            jsonObject.put("city", city.getName());
            district = regionService.queryPoint("district_"+city.getAdcode(), Double.parseDouble(x), Double.parseDouble(y));
        }
        if (district != null) {
            jsonObject.put("area", district.getName());
        }

        return jsonObject;
    }
}
