package org.jplus.service;

import org.jplus.mapper.YjssjjxMapper;
import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.pojo.yjssjjx.YjssjjxAccpet;
import org.jplus.pojo.yjssjjx.Yjssxlxbm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YjssjjxServiceImpl implements YjssjjxService {

    @Autowired
    private YjssjjxMapper yjssjjxMapper;

    @Override
    public List<Yjssxlxbm> getSjlx() {
        return yjssjjxMapper.getSjlx();
    }

    @Override
    public Yjssjjx getYjssjjxJbxx(String gh) {
        return yjssjjxMapper.getYjssjjxJbxx(gh);
    }

    @Override
    public void addYjssjjxInfo(String gh) {
        yjssjjxMapper.addYjssjjxInfo(gh);
    }

    @Override
    public void updateYjsSxJbxx(YjssjjxAccpet yjssjjxAccpet) {
        yjssjjxMapper.updateYjsSxJbxx(yjssjjxAccpet);
    }
}
