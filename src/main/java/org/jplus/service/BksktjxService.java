package org.jplus.service;

import org.jplus.pojo.classTeach.Bksktjx;
import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.pojo.classTeach.Kclx;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
public interface BksktjxService {
    List<Bksktjx> getBksktjxInfo();

    List<Kclx> getKtlxbm();

    Integer getKtlxbmBybm(Integer ktlxbm);

    void addClassInfo(BksktjxAccpet bksktjxAccpet);

    void deleteClassInfoBybksktjxId(Integer bksktjx);

    Float getBkjxgzlSum(String gh);
}
