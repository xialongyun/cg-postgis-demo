package com.x.mapper;

import com.x.entity.Hot;
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
 * @since 2022-11-08
 */
@Mapper
public interface HotMapper extends BaseMapper<Hot> {
    List<Hot> queryHotData(@Param("l_x") Double l_x, @Param("l_y") Double l_y, @Param("r_x") Double r_x, @Param("r_y") Double r_y);
}
