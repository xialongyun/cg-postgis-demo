package com.x.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.x.entity.Market;
import com.x.entity.Province;
import com.x.entity.Table;
import com.x.mapper.CreateTable;
import com.x.mapper.MarketMapper;
import com.x.mapper.ProvinceMapper;
import com.x.service.CreateTableService;
import com.x.service.MarketService;
import com.x.utils.json.ReadJsonFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class CreateTableServiceImpl extends ServiceImpl<CreateTable, Table> implements CreateTableService {
    @Autowired
    CreateTable createTable;
    @Autowired
    ProvinceMapper provinceMapper;

    public CreateTableServiceImpl(CreateTable createTable) {
        this.createTable = createTable;
    }

    public void createTableByName(String tableName) {
        createTable.createTable(tableName);
    }

        public void insert(JSONObject feature) {
        JSONObject properties = JSONObject.parseObject(feature.get("properties").toString());
        Integer adcode = Integer.parseInt(properties.get("adcode").toString());
        Integer index = 0;
        if (properties.containsKey("subFeatureIndex")) {
            index = Integer.parseInt(properties.get("subFeatureIndex").toString());
        }
        String name = properties.get("name").toString();
        String level = properties.get("level").toString();

        Integer children = null;
        if (properties.containsKey("childrenNum")) {
            children = Integer.parseInt(properties.get("childrenNum").toString());
        }

        Integer parent = JSONObject.parseObject(properties.get("parent").toString()).getInteger("adcode");
        String the_geom = feature.get("geometry").toString();
        String tableName = level + "_" + parent;

        if (createTable.isTableExist(tableName) == 0) {
            createTableByName(tableName);
        }
        if (createTable.isKeyExist(tableName, adcode) == 0) {
            createTable.insert(tableName, adcode, index, name, level, children, parent, the_geom);
        }

    }

    public void insertBatch() {
        ArrayList<String> files = ReadJsonFile.getJsonFiles("src/main/resources/chinaGeo/");
        for (String file:files) {
            String collection = ReadJsonFile.readJsonFromFile(file);
            JSONObject jsonObject = JSONObject.parseObject(collection);
            JSONArray features = jsonObject.getJSONArray("features");
            System.out.println(file);
            for (Object f : features) {
                JSONObject feature = JSONObject.parseObject(f.toString());
                insert(feature);
            }
        }
    }

    public void insertProvinceBatch() {
        ReadJsonFile readJsonFile = new ReadJsonFile();
        String collection = readJsonFile.readJsonFromFile("src/main/resources/chinaGeo/中国.json");
        JSONObject jsonObject = JSONObject.parseObject(collection);
        JSONArray features = jsonObject.getJSONArray("features");

        for (Object f : features) {
            JSONObject feature = JSONObject.parseObject(f.toString());
            insert(feature);
        }
    }

    public void createDistrictTable() {

    }

    public void createCityTable(){
        ReadJsonFile readJsonFile = new ReadJsonFile();
        String collection = readJsonFile.readJsonFromFile("src/main/resources/chinaGeo/中国.json");
        JSONObject jsonObject = JSONObject.parseObject(collection);
        JSONArray features = jsonObject.getJSONArray("features");

        for (Object f : features) {
            JSONObject feature = JSONObject.parseObject(f.toString());
            JSONObject properties = JSONObject.parseObject(feature.get("properties").toString());
            Integer adcode = Integer.parseInt(properties.get("adcode").toString());
            createTableByName("city_" + adcode.toString());
        }
    }

    public void createProvince() {
        createTableByName("province_100000");
    }
}
