package org.jplus.service;


import org.jplus.pojo.teachingresearchInfo.Jxcg;
import org.jplus.pojo.teachingresearchInfo.Jxcgdj;

import java.util.List;


public interface JxcgService {
    List<Jxcg> getJxcgInfo(String gh);

    int addJxcg(Jxcg jxcg);

    int deleteJxcg(Integer id);

    List<Jxcgdj> getJxcgdjInfo();

}
