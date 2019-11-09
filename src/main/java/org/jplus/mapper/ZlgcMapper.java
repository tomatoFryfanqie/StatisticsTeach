package org.jplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jplus.pojo.zlgc.Zlgc;
import org.jplus.pojo.zlgc.ZlgcAccept;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: StatisticsTeach
 * @description:
 * @author: MH
 * @create: 2019-11-02 15:19
 **/
@Component
public interface ZlgcMapper {
    public void addZlgcInfo(ZlgcAccept zlgcAccept);

    List<Zlgc> getZlgcInfo();

    Zlgc getOneZlgcInfo();

    public void deleteZlgcInfoById(int zlgcid);

    public void updateZlgcInfoById(ZlgcAccept zlgcAccept);

    public float calculateSumOfWorkLoad();
}
