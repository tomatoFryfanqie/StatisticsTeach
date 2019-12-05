package org.jplus.service;

import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.pojo.yjssjjx.YjssjjxAccpet;
import org.jplus.pojo.yjssjjx.Yjssxlxbm;

import java.util.List;


public interface YjssjjxService {
    List<Yjssxlxbm> getSjlx();

    Yjssjjx getYjssjjxJbxx(String gh);

    void addYjssjjxInfo(String gh);

    void updateYjsSxJbxx(YjssjjxAccpet yjssjjxAccpet);
}
