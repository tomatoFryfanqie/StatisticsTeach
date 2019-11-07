package org.jplus.service;

import org.jplus.mapper.BksktjxMapper;
import org.jplus.pojo.classTeach.Bksktjx;
import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.pojo.classTeach.Kclx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
@Service
public class BksktjxServiceImpl implements BksktjxService {

    @Autowired
    private BksktjxMapper bksktjxMapper;

    @Override
    public List<Bksktjx> getBksktjxInfo(String gh) {
        return bksktjxMapper.getBksktjxInfo(gh);
    }

    @Override
    public List<Kclx> getKtlxbm() {

        return bksktjxMapper.getKtlxbm();
    }

    @Override
    public Integer getKtlxbmBybm(Integer ktlxbm) {
        return bksktjxMapper.getKtlxbmBybm(ktlxbm);
    }

    @Override
    public void addClassInfo(BksktjxAccpet bksktjxAccpet) {
        bksktjxMapper.addClassInfo(bksktjxAccpet);
    }

    @Override
    public void deleteClassInfoBybksktjxId(Integer bksktjx) {
        bksktjxMapper.deleteClassInfoBybksktjxId(bksktjx);
    }

    @Override
    public Float getBkjxgzlSum(String gh) {

        return bksktjxMapper.getBksktjxSum(gh);
    }

}
