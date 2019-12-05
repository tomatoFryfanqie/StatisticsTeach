package org.jplus.service;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.jplus.mapper.TjbMapper;
import org.jplus.pojo.Tjzt.Tjb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TjbServiceImpl implements TjbService {

    @Autowired
    private TjbMapper tjbMapper;

    @Override
    public Tjb getTjbByGh(String gh) {
        return tjbMapper.getTjbByGh(gh);
    }

    @Override
    public List<Tjb> getAllTjb() {
        return tjbMapper.getAllTjb();
    }

    @Override
    public List<Tjb> getAllTjbByYxbm(Integer yxbm) {

        return tjbMapper.getAllTjbByYxbm(yxbm);
    }
}
