package com.x.mapper;

import com.x.entity.SpatialRefSys;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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
public interface SpatialRefSysMapper extends BaseMapper<SpatialRefSys> {

}
