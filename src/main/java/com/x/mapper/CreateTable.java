package com.x.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.x.entity.Market;
import com.x.entity.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CreateTable extends BaseMapper<Table> {
    public void createTable(@Param("tableName") String tableName);
    public void insert(@Param("tableName") String tableName,
            @Param("adcode") Integer adcode,
                               @Param("name") String name,
                               @Param("children") Integer children,
                               @Param("parent") Integer parent,
                               @Param("the_geom") Object the_geom);
}
