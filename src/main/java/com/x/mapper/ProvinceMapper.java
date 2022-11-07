package com.x.mapper;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.x.entity.Province;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author X
 * @since 2022-11-07
 */
@Mapper
@Component
public interface ProvinceMapper extends BaseMapper<Province> {
    public void insertProvince(@Param("adcode") Integer adcode,
                               @Param("name") String name,
                               @Param("center") Object center,
                               @Param("centroid") Object centroid,
                               @Param("children") Integer children,
                               @Param("the_geom") Object the_geom);

    public String queryNameByAdcode(@Param("adcode") Integer adcode);
}
