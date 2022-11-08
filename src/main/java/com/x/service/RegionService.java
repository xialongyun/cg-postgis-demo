package com.x.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.x.entity.Region;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */
public interface RegionService extends IService<Region> {
    Region queryRegionByAdcode(String tableName, Integer adcode);
    Region queryRegionByName(String tableName, String name);
    List<Region> queryRegionList(String tableName, Integer adcode);
    List<Region> queryRegionListByName(String tableName, String name);
    Region queryPoint(String tableName, Double x, Double y);
}
