package com.x.mapper;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.x.entity.Province;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author X
 * @since 2022-11-07
 */
@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
    List<Province> queryAllProvinces();
}
