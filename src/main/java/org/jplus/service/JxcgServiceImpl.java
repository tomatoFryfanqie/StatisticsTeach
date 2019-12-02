package org.jplus.service;

import org.apache.ibatis.annotations.Mapper;
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

    public List<Jxcg> getJxcgInfo(String gh) {
        return jxcgMapper.getJxcg(gh);
    }

    public int addJxcg(Jxcg jxcg) { return jxcgMapper.addJxcg(jxcg); }

    public int deleteJxcg(Integer id) {
        return jxcgMapper.deleteJxcg(id);
    }

    public List<Jxcgdj> getJxcgdjInfo() {return jxcgMapper.getJxcgdjInfo(); }

    public int getGdgzl(Integer id) {return jxcgMapper.getGdgzl(id);}

    public float getJxcgGzlSun(String gh){return jxcgMapper.getJxcgGzlSun(gh);}




    public List<Zxxm> getZxxm(String gh){return jxcgMapper.getZxxm(gh);}

    public int addZxxm(Zxxm zxxm){return jxcgMapper.addZxxm(zxxm);}

    public int deleteZxxm(Integer id){return jxcgMapper.deleteZxxm(id);}

    public List<Zxxmdj> getZxxmdjInfo(){return jxcgMapper.getZxxmdjInfo();}

    public int getZxxmgzl(Integer id){return jxcgMapper.getZxxmgzl(id);}

    public  float getZxxmGzlSun(String gh){return jxcgMapper.getZxxmGzlSun(gh);}



    public List<Hxxm> getHxxm(String gh){return jxcgMapper.getHxxm(gh);}

    public int addHxxm(Hxxm hxxm){return jxcgMapper.addHxxm(hxxm);}

    public int deleteHxxm(Integer id){return jxcgMapper.deleteHxxm(id);}

    public float getHxxmGzlSun(String gh){return jxcgMapper.getHxxmGzlSun(gh);}



    public List<Jc> getJc(String gh){return jxcgMapper.getJc(gh);}

    public int addJc(Jc jc){return jxcgMapper.addJc(jc);}

    public int deleteJc(Integer id){return jxcgMapper.deleteJc(id);}

    public List<Jcjb> getJcjbInfo(){return jxcgMapper.getJcjbInfo();}

    public int getJcGdgzl(Integer id){return jxcgMapper.getJcGdgzl(id);}

     public float getJcGzlSun(String gh){return jxcgMapper.getJcGzlSun(gh);}


    public List<Jxgg> getJxgg(String gh){return jxcgMapper.getJxgg(gh);}

    public int addJxgg(Jxgg jxgg){return jxcgMapper.addJxgg(jxgg);}

    public int deleteJxgg(Integer id){return jxcgMapper.deleteJxgg(id);}

    public List<Lxjb> getLxjbInfo(){return jxcgMapper.getLxjbInfo();}

    public int getJxgggzl(Integer id){return jxcgMapper.getLxjbGdgzl(id);}

    public float getJxggGzlSun(String gh){return jxcgMapper.getJxggGzlSun(gh);}
}
