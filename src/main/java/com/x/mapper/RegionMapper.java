package com.x.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.x.entity.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RegionMapper extends BaseMapper<Region> {
    Region queryRegionByAdcode(@Param("tableName") String tableName,
                       @Param("adcode") Integer adcode);

    Region queryRegionByName(@Param("tableName") String tableName,
                               @Param("name") String name);

    Region isRegionProvince(@Param("tableName") String tableName,
                             @Param("name") String name);

    List<Region> queryRegionList(@Param("tableName") String tableName, @Param("adcode") Integer adcode);
    List<Region> queryRegionListByName(@Param("tableName") String tableName, @Param("name") String name);
    Region queryPoint(@Param("tableName") String tableName, @Param("x") Double x,@Param("y") Double y);
}
