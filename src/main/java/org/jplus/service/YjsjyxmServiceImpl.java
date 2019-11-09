package org.jplus.service;

import org.jplus.mapper.YjsjyxmMapper;
import org.jplus.pojo.yjsjyxm.Yjshxxm;
import org.jplus.pojo.yjsjyxm.Yjsjyxm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:研究生教研项目实现类
 * @author:zmj
 * @date 2019/11/817:00
 */
@Service
public class YjsjyxmServiceImpl implements YjsjyxmService{

    @Autowired
    private YjsjyxmMapper yjsjyxmMapper;

    public List<Yjsjyxm> getYjsjyxm() {
        return yjsjyxmMapper.getYjsjyxm();
    }

    public int delYjsjyxm(Integer id) {
        return yjsjyxmMapper.delYjsjyxm(id);
    }

    public int addYjsjyxm(Yjsjyxm yjsjyxm) {
        return yjsjyxmMapper.addYjsjyxm(yjsjyxm);
    }

    public float getYjsjyxmGzlSum(String gh) {
        return yjsjyxmMapper.getYjsjyxmGzlSum(gh);
    }

    public List<Yjshxxm> getYjshxxm() {
        return yjsjyxmMapper.getYjshxxm();
    }

    public int delYjshxxm(Integer id) {
        return yjsjyxmMapper.delYjshxxm(id);
    }

    public int addYjshxxm(Yjshxxm yjshxxm) {
        return yjsjyxmMapper.addYjshxxm(yjshxxm);
    }

    public float getYjshxxmGzlSum(String gh) {
        return yjsjyxmMapper.getYjshxxmGzlSum(gh);
    }
}
