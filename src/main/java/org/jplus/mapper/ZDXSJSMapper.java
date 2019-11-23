package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.queryVo.ZdxsjsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 14:51
 */
@Repository
public interface ZDXSJSMapper {

    void addZDXSJS(ZDXSJS zDXSJS);

    //List<ZDXSJS> getStudentCompetitionList(@Param("gh") String gh, @Param("nd") Integer nd);

    Float getGzl(@Param("competition") Integer competition, @Param("contestLevel") Integer contestLevel);

    Float getAllGzl(@Param("gh") String gh, @Param("nd") Integer nd);

    void remove(@Param("id") Integer id);

    ZDXSLW findZDXSLWByGhAndYear(@Param("gh") String gh, @Param("nd") Integer nd);

    //List<ZDXSJS> getStudentCompetitionList2(@Param("gh") String gh, @Param("nd") Integer nd);

    Float getAllGzl2(@Param("gh") String gh, @Param("nd") Integer nd);

    Integer isOnlyForOneYear(@Param("gh") String gh, @Param("nd") Integer nd);

    List<ZdxsjsVo> getStudentCompetitionList(@Param("gh") String gh, @Param("nd") Integer nd);

    List<ZdxsjsVo> getStudentCompetitionList2(@Param("gh") String gh, @Param("nd") Integer nd);
}
