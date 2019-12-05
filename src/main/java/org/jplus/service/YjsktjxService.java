package org.jplus.service;

import org.jplus.pojo.Users;
import org.jplus.pojo.yjsktjx.Yjskclx;
import org.jplus.pojo.yjsktjx.Yjsktjx;
import org.jplus.pojo.yjsktjx.YjsktjxAccpet;

import java.util.List;


public interface YjsktjxService {

    List<Yjskclx> getKclx();

    List<Yjsktjx> getYjsktjxInfo(String gh);

    Float getYjsjxgzlSum(String gh);

    Integer getKclxrsBybm(Integer kclx);

    void addYjsClassInfo(YjsktjxAccpet yjsktjxAccpet);

    void deleteClassInfoBybksktjxId(Integer id);
}
