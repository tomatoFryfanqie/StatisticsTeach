package org.jplus.service;

import org.jplus.pojo.zlgc.Zlgc;
import org.jplus.pojo.zlgc.ZlgcAccept;

import java.util.List;



public interface ZlgcService {

    void addZlgcInfo(ZlgcAccept zlgcAccept);

    void deleteZlgcInfo(Integer zlgcid);

    List<Zlgc> getZlgcInfo(String gh);

    void updateZlgcInfo(ZlgcAccept zlgcAccept);

    public Float calculateSumOfWorkLoad(String gh);
}
