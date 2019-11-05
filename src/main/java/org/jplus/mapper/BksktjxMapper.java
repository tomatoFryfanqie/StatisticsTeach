package org.jplus.mapper;

import org.jplus.pojo.classTeach.Bksktjx;
import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.pojo.classTeach.Kclx;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
public interface BksktjxMapper {

    List<Bksktjx> getBksktjxInfo();

    List<Kclx> getKtlxbm();

    Integer getKtlxbmBybm(Integer ktlxbm);

    void addClassInfo(BksktjxAccpet bksktjxAccpet);

    void deleteClassInfoBybksktjxId(Integer bksktjx);

    Float getBksktjxSum(String gh);
<<<<<<< HEAD
=======

>>>>>>> origin/master
}
