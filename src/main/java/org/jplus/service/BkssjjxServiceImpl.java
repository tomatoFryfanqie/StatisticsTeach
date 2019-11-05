package org.jplus.service;


import org.jplus.mapper.BkssjjxMapper;
import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.pojo.bks.Sxlx;
import org.jplus.pojo.bks.Zylxbm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/10/30 16:10
 */
@Service
public class BkssjjxServiceImpl implements BkssjjxService {

    @Autowired
    private BkssjjxMapper bkssjjxMapper;

    @Override
    public int insertBkssjjx(Bkssjjx bkssjjx) {
        return  bkssjjxMapper.insertBkssjjx(bkssjjx);
    }

    @Override
    public Bkssjjx selectBkssjjx(String gh) {
        return bkssjjxMapper.selectBkssjjx(gh);
    }

    @Override
    public List<Sxlx> selectSxlx() {
        return bkssjjxMapper.selectSxlx();
    }

    @Override
    public List<Zylxbm> selectZylxbm() {
        return bkssjjxMapper.selectZylxbm();
    }
}
