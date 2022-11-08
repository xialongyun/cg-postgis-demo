package com.x.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.x.entity.Table;
import com.x.mapper.CreateTable;
import com.x.utils.json.ReadJsonFile;

import java.util.ArrayList;

public interface CreateTableService extends IService<Table> {
    void createTableByName(String tableName);
    void insert(JSONObject feature);
    void insertBatch();
    void insertProvinceBatch();
    void createCityTable();
    void createProvince();
}
