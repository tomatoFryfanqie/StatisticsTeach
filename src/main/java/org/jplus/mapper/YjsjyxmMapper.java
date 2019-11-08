package org.jplus.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.jplus.pojo.yjsjyxm.Yjshxxm;
import org.jplus.pojo.yjsjyxm.Yjsjyxm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:研究生教研项目持久层
 * @author:zmj
 * @date 2019/11/816:24
 */
@Component
public interface YjsjyxmMapper {
//获取研究生教研项目列表
    @Select("select * from yjsjyxm")
    List<Yjsjyxm> getYjsjyxm();

//删除一条数据
    @Delete("delete from yjsjyxm where jyxmId = #{id}")
    int delYjsjyxm(Integer id);

//新增一条数据
    @Insert("insert into yjsjyxm values(null,#{gh},#{nd},#{xmmc},#{xmdjbm},#{xmpm},#{zrs},#{gzl})")
    int addYjsjyxm(Yjsjyxm yjsjyxm);

//计算工作量总和
    @Select("select coalesce(sum(gzl),0) jxcggzlsum from yjsjyxm where gh = (#{gh})")
    float getYjsjyxmGzlSum(String gh);

//获取研究生横向项目列表
    @Select("select * from yjshxxm")
    List<Yjshxxm> getYjshxxm();

//删除一条数据
    @Delete("delete from yjshxxm where hxxmId = #{id}")
    int delYjshxxm(Integer id);

//新增一条数据
    @Insert("insert into yjshxxm values(null,#{gh},#{nd},#{xmmc},#{dzjf},#{xmpm},#{zrs},#{gzl})")
    int addYjshxxm(Yjshxxm yjshxxm);

//计算工作量总和
    @Select("select coalesce(sum(gzl),0) jxcggzlsum from yjshxxm where gh = (#{gh})")
    float getYjshxxmGzlSum(String gh);

}
