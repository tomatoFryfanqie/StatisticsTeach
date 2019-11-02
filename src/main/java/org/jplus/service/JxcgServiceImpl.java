package org.jplus.service;

import org.jplus.mapper.JxcgMapper;
import org.jplus.pojo.teachingresearchInfo.Jxcg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 教学成果服务层实现
 * @author:zmj
 * @date 2019/11/116:28
 */
@Service
public class JxcgServiceImpl implements JxcgService {

    @Autowired
   private JxcgMapper jxcgMapper;

    public List<Jxcg> getJxcgInfo() {
        return jxcgMapper.getJxcg();
    }

    public int addJxcg(Jxcg jxcg) {

        return jxcgMapper.addJxcg(jxcg);
    }

    public int updateJxcg(Integer id) {
        return jxcgMapper.updateJxcg(id);
    }

    public int deleteJxcg(Integer id) {
        return jxcgMapper.deleteJxcg(id);
    }


    public String getCgdjmcById() {
        return jxcgMapper.getCgdjmcById();
    }
}
