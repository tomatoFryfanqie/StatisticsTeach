package org.jplus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.pojo.bks.Sxlx;
import org.jplus.pojo.bks.Zylxbm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/10/30 15:46
 */
@Mapper
@Component
public interface BkssjjxMapper {

    @Insert("insert into bkssjjx (gh,nd,sxlxbm1,sxts1,sxlxbm2,sxts2,sxlxbm3,sxts3,wgsjrs,zylxbm,zdlwrs,glnr,glgzl," +
            "gzl) values (#{gh},#{nd},#{sxlxbm1},#{sxts1},#{sxlxbm2},#{sxts2},#{sxlxbm3},#{sxts3},#{wgsjrs}," +
            "#{zylxbm}," +
            "#{zdlwrs},#{glnr},#{glgzl},#{gzl})")
    int insertBkssjjx(Bkssjjx bkssjjx);

    @Select("select gh,nd,sxlxbm1,sxts1,sxlxbm2,sxts2,sxlxbm3,sxts3,wgsjrs,zylxbm,zdlwrs,glnr,glgzl,gzl from bkssjjx where gh=#{gh}")
    Bkssjjx selectBkssjjx(String gh);

    @Select("select sxlxbm , sxlxmc from sxlx")
    List<Sxlx> selectSxlx();

    @Select("select zylxbm , zylxmc from zylxbm")
    List<Zylxbm> selectZylxbm();

    @Update("update bkssjjx set nd=#{nd},sxlxbm1=#{sxlxbm1},sxts1=#{sxts1},sxlxbm2=#{sxlxbm2},sxts2=#{sxts2}," +
            "sxlxbm3=#{sxlxbm3},sxts3=#{sxts3}, wgsjrs=#{wgsjrs},zylxbm=#{zylxbm},zdlwrs=#{zdlwrs}, " +
            "glnr=#{glnr},glgzl=#{glgzl},gzl=#{gzl} where gh=#{gh}")
    void updateBksjjx(Bkssjjx bkssjjx);
}
