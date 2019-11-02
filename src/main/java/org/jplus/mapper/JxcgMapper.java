package org.jplus.mapper;

import org.apache.ibatis.annotations.*;
import org.jplus.pojo.teachingresearchInfo.*;

import java.util.List;

/**
 * @description: 教学成就mapper接口
 * @author:zmj
 * @date 2019/10/3116:35
 */
@Mapper
public interface JxcgMapper {
//获取教学成果信息
    @Select("select * from jxcg")
     List<Jxcg> getJxcg();

//添加教学成果信息
    @Insert("insert into jxcg values(null,null,null,#{cgmc}),#{cgdj},#{xmpm},#{xmzrs},#{jxcggzl}")
      int addJxcg(Jxcg jxcg);

//修改教学成果信息
    @Update("update jxcg set cgmc=#{cgmc},cgdj=#{cgdj},xmpm={xmpm},jxcgzrs=#{xmzrs},jxcggzl=#{jxcggzl} where jxcgid=#{jxcgid}")
    int updateJxcg(Integer id);

//删除教学成果信息
    @Delete("delete from jxcg where jxcgid=#{id}")
     int deleteJxcg(Integer id);

//成果等级名称查询
   @Select("select cgdjmc from jxcgdj,jxcg where jxcgdj.cgdjbm=jxcg.cgdjbm")
    String getCgdjmcById();
}
