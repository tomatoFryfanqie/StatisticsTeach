package org.jplus.service;

import org.jplus.mapper.JxcgMapper;
import org.jplus.pojo.teachingresearchInfo.*;
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

    public int addJxcg(Jxcg jxcg) { return jxcgMapper.addJxcg(jxcg); }

    public int updateJxcg(Integer id) {
        return jxcgMapper.updateJxcg(id);
    }

    public int deleteJxcg(Integer id) {
        return jxcgMapper.deleteJxcg(id);
    }

    public List<Jxcgdj> getJxcgdjInfo() {return jxcgMapper.getJxcgdjInfo(); }

    public List<Zxxm> getZxxm(){return jxcgMapper.getZxxm();}

    public int addZxxm(Zxxm zxxm){return jxcgMapper.addZxxm(zxxm);}

    public int updateZxxm(Integer id){return jxcgMapper.updateZxxm(id);}

    public int deleteZxxm(Integer id){return jxcgMapper.deleteZxxm(id);}

    List<Zxxmdj> getZxxmdjInfo(){return jxcgMapper.getZxxmdjInfo();}

    public List<Hxxm> getHxxm(){return jxcgMapper.getHxxm();}

    public int addHxxm(Hxxm hxxm){return jxcgMapper.addHxxm(hxxm);}

    public int updateHxxm(Integer id){return jxcgMapper.updateHxxm(id);}

    public int deleteHxxm(Integer id){return jxcgMapper.deleteHxxm(id);}

    public List<Jc> getJc(){return jxcgMapper.getJc();}

    public int addJc(Jc jc){return jxcgMapper.addJc(jc);}

    public int updateJc(Integer id){return jxcgMapper.updateJc(id);}

    public int deleteJc(Integer id){return jxcgMapper.deleteJc(id);}

    List<Jcjb> getJcjbInfo(){return jxcgMapper.getJcjbInfo();}

    public List<Jxgg> getJxgg(){return jxcgMapper.getJxgg();}

    public int addJxgg(Jxgg jxgg){return jxcgMapper.addJxgg(jxgg);}

    public int updateJxgg(Integer id){return jxcgMapper.updateJxgg(id);}

    public int deleteJxgg(Integer id){return jxcgMapper.deleteJxgg(id);}

    List<Lxjb> getLxjbInfo(){return jxcgMapper.getLxjbInfo();}
}
