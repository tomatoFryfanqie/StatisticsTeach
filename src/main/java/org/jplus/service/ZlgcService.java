package org.jplus.service;

import org.jplus.pojo.zlgc.Zlgc;
import org.jplus.pojo.zlgc.ZlgcAccept;

import java.util.List;

/**
 * @program: StatisticsTeach
 * @description: 质量工程业务类
 * @author: MH
 * @create: 2019-11-02 15:26
 **/

public interface ZlgcService {

    void addZlgcInfo(ZlgcAccept zlgcAccept);

    void deleteZlgcInfo(int zlgcid);

    List<Zlgc> getZlgcInfo(String gh);

    void updateZlgcInfo(ZlgcAccept zlgcAccept);

    public Float calculateSumOfWorkLoad(String gh);
}
