package com.x.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.x.entity.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TabbleMapper extends BaseMapper<Table> {
    public String queryNameByAdcode(@Param("adcode") Integer adcode);

    public Integer isTableExist(@Param("tableName") String tableName);

    public Integer isKeyExist(@Param("tableName") String tableName,
                              @Param("adcode") Integer adcode);


}
