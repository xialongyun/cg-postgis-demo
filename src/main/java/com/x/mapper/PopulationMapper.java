package com.x.mapper;

import com.x.entity.Population;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
@Mapper
public interface PopulationMapper extends BaseMapper<Population> {
    Long countPopulationByGeoJson(@Param("geom") String json);
    List<Population> selectPopulationByGeoJson(@Param("geom") String json);
}
