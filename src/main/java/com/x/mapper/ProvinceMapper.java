package com.x.mapper;

import com.x.entity.Province;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author X
 * @since 2022-11-06
 */
@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
    public void insertProvince(@Param("adcode") Integer adcode,
                               @Param("name") String name,
                               @Param("center") String center,
                               @Param("centroid") String centroid,
                               @Param("children") Integer children,
                               @Param("the_geom") String the_geom);
}
