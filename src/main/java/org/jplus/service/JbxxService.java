package org.jplus.service;

import org.jplus.pojo.Users;
import org.jplus.pojo.basisInfo.*;

import java.util.List;

public interface JbxxService {
    Jbxx getJbxxInfo(String gh);

    List<Yxbm> getYxbmInfo();

    List<Zwbm> getZwbmInfo();

    List<Zcbm> getZcbmInfo();

    List<Gwlxbm> getGwlxbmInfo();

    void updateBasisInfo(JbxxAccpet jbxxAccpet);

    void addJbxx(String gh);

    Float getZgzl(String gh);
}
