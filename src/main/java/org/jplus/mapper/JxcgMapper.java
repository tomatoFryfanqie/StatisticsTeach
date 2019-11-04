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
// ---------------------------教学成果-------------------------
//获取教学成果信息
    @Select("select * from jxcg")
     List<Jxcg> getJxcg();

//添加教学成果信息
    @Insert("insert into jxcg values(null,#{gh},#{nd},#{cgmc},#{cgdjbm},#{xmpm},#{jxcgzrs},#{jxcggzl})")
      int addJxcg(Jxcg jxcg);

//修改教学成果信息
    @Update("update jxcg set cgmc=#{cgmc},cgdj=#{cgdj},xmpm={xmpm},jxcgzrs=#{xmzrs},jxcggzl=#{jxcggzl} where jxcgid=#{jxcgid}")
    int updateJxcg(Integer id);

//删除教学成果信息
    @Delete("delete from jxcg where jxcgid=#{id}")
     int deleteJxcg(Integer id);

//查询成果等级信息
    @Select("select * from jxcgdj")
    List<Jxcgdj> getJxcgdjInfo();

//------------------------------纵向项目------------------------------------
//获取纵向教研项目信息
    @Select("select * from xxm")
    List<Zxxm> getZxxm();

    //添加纵向项目信息
    @Insert("insert into zxxm values(null,#{gh},#{nd},#{xmmc},#{xmdjbm},#{xmpm},#{xmzrs},#{zxxmgzl})")
    int addZxxm(Zxxm zxxm);

    //修改纵向项目信息
    @Update("update jxcg set cgmc=#{cgmc}z,cgdj=#{cgdj},xmpm={xmpm},jxcgzrs=#{xmzrs},jxcggzl=#{jxcggzl} where jxcgid=#{jxcgid}")
    int updateZxxm(Integer id);

    //删除纵向项目信息
    @Delete("delete from zxxm where zxxmid=#{id}")
    int deleteZxxm(Integer id);

    //查询纵向项目等级信息
    @Select("select * from zxxmdj")
    List<Zxxmdj> getZxxmdjInfo();

//---------------------------------横向项目------------------------------------------
//获取横向项目信息
    @Select("select * from hxxm")
    List<Hxxm> getHxxm();

    //添加横向项目信息
    @Insert("insert into hxxm values(null,#{gh},#{nd},#{dzjf},#{xmpm},#{xmzrs},#{hxgzl})")
    int addHxxm(Hxxm hxxm);

    //修改横向项目信息
    @Update("update jxcg set cgmc=#{cgmc},cgdj=#{cgdj},xmpm={xmpm},jxcgzrs=#{xmzrs},jxcggzl=#{jxcggzl} where jxcgid=#{jxcgid}")
    int updateHxxm(Integer id);

    //删除横向项目信息
    @Delete("delete from hxxm where hxxmid=#{id}")
    int deleteHxxm(Integer id);

//-------------------------------------教材-------------------------------------------
//获取教材信息
    @Select("select * from jc")
    List<Jc> getJc();

    //添加教材信息
    @Insert("insert into jc values(null,#{gh},#{nd},#{jcmc},#{jcjbbm},#{xmpm},#{xmzrs},#{jcgzl})")
    int addJc(Jc jc);

    //修改教材信息
    @Update("update jxcg set cgmc=#{cgmc},cgdj=#{cgdj},xmpm={xmpm},jxcgzrs=#{xmzrs},jxcggzl=#{jxcggzl} where jxcgid=#{jxcgid}")
    int updateJc(Integer id);

    //删除教材信息
    @Delete("delete from jc where jcid=#{id}")
    int deleteJc(Integer id);

    //查询教材级别信息
    @Select("select * from jcjb")
    List<Jcjb> getJcjbInfo();

// ---------------------------------------教学改革--------------------------------------------
//获取教学改革信息
@Select("select * from jxgg")
List<Jxgg> getJxgg();

    //添加教学改革信息
    @Insert("insert into jxgg values(null,#{gh},#{nd},#{xmmc},#{lxjbbm},#{xmpm},#{jxggzrs},#{jxgggzl})")
    int addJxgg(Jxgg jxgg);

    //修改教学改革信息
    @Update("update jxcg set cgmc=#{cgmc},cgdj=#{cgdj},xmpm={xmpm},jxcgzrs=#{xmzrs},jxcggzl=#{jxcggzl} where jxcgid=#{jxcgid}")
    int updateJxgg(Integer id);

    //删除教学改革信息
    @Delete("delete from jxgg where jxggid=#{id}")
    int deleteJxgg(Integer id);

    //查询立项级别信息
    @Select("select * from lxjb")
    List<Lxjb> getLxjbInfo();
}
