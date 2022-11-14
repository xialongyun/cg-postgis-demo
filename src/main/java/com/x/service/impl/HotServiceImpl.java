package com.x.service.impl;

import com.x.entity.Hot;
import com.x.mapper.HotMapper;
import com.x.service.HotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
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

    /**
     * 热点数据
     */
    @Override
    public List<Hot> queryHotData(Double l_x, Double l_y, Double r_x, Double r_y) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long now = date.getTime();
        List<Hot> hot = hotMapper.queryHotData(l_x,l_y,r_x,r_y);
        hot.sort((o1, o2) -> {
            int factor1 = 1, factor2 = 1;
            try {
                long diff1 = (now - format.parse(o1.getGmtCreatetime()).getTime())/(24 * 60 * 60 * 1000);
                if (diff1 > 10) {
                    factor1 = 1;
                } else if (diff1 < 3) {
                    factor1 = 10;
                } else {
                    factor1 = 5;
                }

                long diff2 = (now - format.parse(o2.getGmtCreatetime()).getTime())/(24 * 60 * 60 * 1000);
                if (diff2 > 10) {
                    factor2 = 1;
                } else if (diff2 < 3) {
                    factor2 = 10;
                } else {
                    factor2= 5;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

            return factor2 * (1 + Integer.parseInt(o2.getReadAmount())
                    + Integer.parseInt(o2.getCommentAmount())
                    + Integer.parseInt(o2.getShareAmount())
                    + Integer.parseInt(o2.getFocusAmount()))
                    * Integer.parseInt(o2.getHotLevel())
                    - factor1 * (1 + Integer.parseInt(o1.getReadAmount())
                    + Integer.parseInt(o1.getCommentAmount())
                    + Integer.parseInt(o1.getShareAmount())
                    + Integer.parseInt(o1.getFocusAmount()))
                    * Integer.parseInt(o1.getHotLevel());
        });

        return hot;
    }
}
