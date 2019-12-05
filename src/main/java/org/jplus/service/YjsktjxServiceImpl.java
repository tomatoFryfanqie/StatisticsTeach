package org.jplus.service;

import org.jplus.mapper.YjsktjxMapper;
import org.jplus.pojo.Users;
import org.jplus.pojo.yjsktjx.Yjskclx;
import org.jplus.pojo.yjsktjx.Yjsktjx;
import org.jplus.pojo.yjsktjx.YjsktjxAccpet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YjsktjxServiceImpl implements YjsktjxService {

    @Autowired
    private YjsktjxMapper yjsktjxMapper;

    @Override
    public List<Yjskclx> getKclx() {
        return yjsktjxMapper.getYjskclx();
    }

    @Override
    public List<Yjsktjx> getYjsktjxInfo(String gh) {
        return yjsktjxMapper.getYjsktjxInfo(gh);
    }

    @Override
    public Float getYjsjxgzlSum(String gh) {
        return yjsktjxMapper.getYjsjxgzlSum(gh);
    }

    @Override
    public Integer getKclxrsBybm(Integer kclx) {
        return yjsktjxMapper.getKclxrsBybm(kclx);
    }

    @Override
    public void addYjsClassInfo(YjsktjxAccpet yjsktjxAccpet) {
        yjsktjxMapper.addYjsClassInfo(yjsktjxAccpet);
    }

    @Override
    public void deleteClassInfoBybksktjxId(Integer id) {
        yjsktjxMapper.deleteClassInfoBybksktjxId(id);
    }
}
