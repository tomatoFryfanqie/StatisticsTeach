package org.jplus.service;

import org.jplus.pojo.classTeach.Bksktjx;
import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.pojo.classTeach.Kclx;

import java.util.List;


public interface BksktjxService {
    List<Bksktjx> getBksktjxInfo(String gh);

    List<Kclx> getKtlxbm();

    Integer getKtlxbmBybm(Integer ktlxbm);

    void addClassInfo(BksktjxAccpet bksktjxAccpet);

    void deleteClassInfoBybksktjxId(Integer bksktjx);

    Float getBkjxgzlSum(String gh);

}
