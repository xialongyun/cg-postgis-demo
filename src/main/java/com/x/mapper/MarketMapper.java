package com.x.mapper;

import com.x.entity.Market;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
@Repository
public interface MarketMapper extends BaseMapper<Market> {
    List<Market> selectByGid(@Param("m_gid") Integer gid);
    List<Market> selectByGeoJson(@Param("text") String json);
    List<Market> selectMarketByGeoJson(@Param("geom") String json);
    Integer countMarketNumByGeoJson(@Param("geom") String json);
}
