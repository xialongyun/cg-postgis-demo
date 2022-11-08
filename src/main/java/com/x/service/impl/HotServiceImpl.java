package com.x.service.impl;

import com.x.entity.Hot;
import com.x.mapper.HotMapper;
import com.x.service.HotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author X
 * @since 2022-11-08
 */
@Service
public class HotServiceImpl extends ServiceImpl<HotMapper, Hot> implements HotService {
    @Autowired
    HotMapper hotMapper;

    public HotServiceImpl(HotMapper hotMapper) {
        this.hotMapper = hotMapper;
    }
    @Override
    public List<Hot> queryHotData(Double l_x, Double l_y, Double r_x, Double r_y) {
        return hotMapper.queryHotData(l_x,l_y,r_x,r_y);
    }
}
