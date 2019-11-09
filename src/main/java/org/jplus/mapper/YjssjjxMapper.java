package org.jplus.mapper;

import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.pojo.yjssjjx.YjssjjxAccpet;
import org.jplus.pojo.yjssjjx.Yjssxlxbm;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/11/7
 * @Description: Description
 */
public interface YjssjjxMapper {
    List<Yjssxlxbm> getSjlx();

    Yjssjjx getYjssjjxJbxx(String gh);

    void addYjssjjxInfo(String gh);

    void updateYjsSxJbxx(YjssjjxAccpet yjssjjxAccpet);
}
