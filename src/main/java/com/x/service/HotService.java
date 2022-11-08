package com.x.service;

import com.x.entity.Hot;
import com.baomidou.mybatisplus.extension.service.IService;
import com.x.mapper.HotMapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author X
 * @since 2022-11-08
 */
public interface HotService extends IService<Hot> {

    List<Hot> queryHotData(Double l_x, Double l_y, Double r_x, Double r_y);
}
