package com.x.mapper;

import com.x.entity.Population;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
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
@Component
public interface PopulationMapper extends BaseMapper<Population> {
    BigInteger countPopulationByGeoJson(@Param("geom") String json);
    List<Population> selectPopulationByGeoJson(@Param("geom") String json);
}
