package com.x.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.entity.Province;
import com.x.mapper.ProvinceMapper;
import com.x.service.ProvinceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.x.utils.json.ReadJsonFile;
import org.geotools.geojson.geom.GeometryJSON;
import org.junit.runner.RunWith;
import org.postgis.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

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

    public void insertProvince(JSONObject feature) throws IOException {
        JSONObject properties = JSONObject.parseObject(feature.get("properties").toString());
        Integer adcode = Integer.parseInt(properties.get("adcode").toString());
        String name = properties.get("name").toString();
        String center = null;
//        if (properties.containsKey("center")) {
//            center = "{\"type\":Point,\"coordinates\":" + properties.get("center").toString() +"}";
//        }
//        GeometryJSON geometryJSON = new GeometryJSON();
//        String centerString = geometryJSON.read(center).toString();

        String centroid  = null;
//        if (properties.containsKey("centroid")) {
//            centroid = "{\"type\":Point,\"coordinates\":" + properties.get("centroid").toString() +"}";
//        }
        Integer children = null;
        if (properties.containsKey("childrenNum")) {
            children = Integer.parseInt(properties.get("childrenNum").toString());
        }

        String the_geom = feature.get("geometry").toString();

        provinceMapper.insertProvince(adcode,name,center,centroid,children,the_geom);
    }

    public void insert(JSONObject feature) throws IOException {

        JSONObject properties = JSONObject.parseObject(feature.get("properties").toString());
        Integer adcode = Integer.parseInt(properties.get("adcode").toString());
        String name = properties.get("name").toString();
        String center = null;
        if (properties.containsKey("center")) {
            center = "{\"type\":Point,\"coordinates\":" + properties.get("center").toString() + "}";
        }
        String centroid  = null;
        if (properties.containsKey("centroid")) {
            centroid = "{\"type\":Point,\"coordinates\":" + properties.get("centroid").toString() + "}";
        }
        JSONObject centerJson = JSONObject.parseObject(center);
        Integer children = null;
        if (properties.containsKey("childrenNum")) {
            children = Integer.parseInt(properties.get("childrenNum").toString());
        }

        Object the_geom = feature.get("geometry");
        GeometryJSON geometryJSON = new GeometryJSON();
        //org.locationtech.jts.geom.Geometry geo = geometryJSON.read(the_geom);


        Province province = new Province();

        province.setAdcode(adcode);
        province.setCenter(center);
        province.setCentroid(centroid);
        province.setName(name);
        province.setTheGeom(null);
        province.setChildren(children);

        System.out.println(adcode);
        System.out.println(name);
        System.out.println(center);
        System.out.println(centroid);
        System.out.println(children);
        System.out.println(the_geom);

        System.out.println(province);

        int i = provinceMapper.insert(province);
        System.out.println(i);

    }

    public void insertBatch() throws IOException {

        ReadJsonFile readJsonFile = new ReadJsonFile();
        String collection = readJsonFile.readJsonFromFile("src/main/resources/chinaGeo/中国.json");
        JSONObject jsonObject = JSONObject.parseObject(collection);
        JSONArray features = jsonObject.getJSONArray("features");

        for (Object f : features) {
            JSONObject feature = JSONObject.parseObject(f.toString());
            insertProvince(feature);
        }
    }
}
