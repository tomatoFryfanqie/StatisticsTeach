package org.jplus.service;


import org.jplus.pojo.teachingresearchInfo.Jxcg;

import java.util.List;

/**
 * @description: 教学成果服务层
 * @author:zmj
 * @date 2019/11/116:25
 */

public interface JxcgService {
    List<Jxcg> getJxcgInfo();

    int addJxcg(Jxcg jxcg);

    int updateJxcg(Integer id);

    int deleteJxcg(Integer id);

    String getCgdjmcById();
}
