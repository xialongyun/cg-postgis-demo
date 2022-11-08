package com.x.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.entity.Hot;
import com.x.mapper.HotMapper;
import com.x.service.impl.HotServiceImpl;
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
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/hot")
public class HotController {
    @Autowired
    HotMapper hotMapper;
    //http://127.0.0.1:8800/hot/queryHotData?l_x=116.366794&l_y=39.915309&r_x=117.366794&r_y=38.915309
    /**
     * 求构造区域内的热点数据
     * @param l_x 左上经度
     * @param l_y 左上纬度
     * @param r_x 右上经度
     * @param r_y 右下纬度
     * @return 热点数据Json
     */
    @GetMapping("/queryHotData")
    public JSONObject queryHotData(Double l_x, Double l_y, Double r_x, Double r_y) {
        HotServiceImpl hotService = new HotServiceImpl(hotMapper);
        List<Hot> list = hotService.queryHotData(l_x,l_y,r_x,r_y);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (int i = 1; i <= list.size(); i++) {
            JSONObject object = new JSONObject();
            object.put("id", i);
            object.put("title", list.get(i - 1).getTitle());
            jsonArray.add(object);
        }

        jsonObject.put("titles", jsonArray);
        return jsonObject;
    }
}
