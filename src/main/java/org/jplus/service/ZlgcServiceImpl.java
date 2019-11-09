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
        System.out.println("准备添加到数据库：");
        zlgcMapper.addZlgcInfo(zlgcAccept);
    }

    @Override
    public void deleteZlgcInfo(int zlgcid) {
        System.out.println("准备删除：");
        zlgcMapper.deleteZlgcInfoById(zlgcid);
    }

    @Override
    public List<Zlgc> getZlgcInfo() {
        List<Zlgc> list = zlgcMapper.getZlgcInfo();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("取出数据" + list.get(i));
        }
        return zlgcMapper.getZlgcInfo();
    }

    @Override
    public void updateZlgcInfo(ZlgcAccept zlgcAccept) {
        zlgcMapper.updateZlgcInfoById(zlgcAccept);
    }

    @Override
    public float calculateSumOfWorkLoad() {
        return zlgcMapper.calculateSumOfWorkLoad();
    }

    public static void main(String[] args) {
        ZlgcAccept zlgcAccept = new ZlgcAccept();
        zlgcAccept.setGh("dddd");
        zlgcAccept.setZlgcid(1);
        zlgcAccept.setXmlxbm(1);
        zlgcAccept.setXmmc("xin");
        zlgcAccept.setJb(1);
        zlgcAccept.setXmpm(1);
        zlgcAccept.setZrs(1);
        System.out.println(zlgcAccept);
        ZlgcServiceImpl zlgcService = new ZlgcServiceImpl();
        zlgcService.updateZlgcInfo(zlgcAccept);
    }
}
