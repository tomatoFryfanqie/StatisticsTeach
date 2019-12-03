package org.jplus.service;

import org.jplus.mapper.ZlgcMapper;
import org.jplus.pojo.zlgc.Zlgc;
import org.jplus.pojo.zlgc.ZlgcAccept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: StatisticsTeach
 * @description:
 * @author: MH
 * @create: 2019-11-02 15:27
 **/
@Service
public class ZlgcServiceImpl implements ZlgcService {
    @Autowired
    private ZlgcMapper zlgcMapper;

    @Override
    public void addZlgcInfo(ZlgcAccept zlgcAccept) {
        zlgcMapper.addZlgcInfo(zlgcAccept);
    }

    @Override
    public void deleteZlgcInfo(Integer zlgcid) {
        zlgcMapper.deleteZlgcInfoById(zlgcid);
    }

    @Override
    public List<Zlgc> getZlgcInfo(String gh) {
        return zlgcMapper.getZlgcInfo(gh);
    }

    @Override
    public void updateZlgcInfo(ZlgcAccept zlgcAccept) {
        zlgcMapper.updateZlgcInfoById(zlgcAccept);
    }

    @Override
    public Float calculateSumOfWorkLoad(String gh) {
        Float workload = 0.0f;
        if (zlgcMapper.calculateSumOfWorkLoad(gh) != null){
            workload = zlgcMapper.calculateSumOfWorkLoad(gh);
        }
        return workload;
    }
}
