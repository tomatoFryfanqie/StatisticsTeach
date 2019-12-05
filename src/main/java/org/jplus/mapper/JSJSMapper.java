package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.undergraduateCompatitonAndOther.JSJS;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSLW;
import org.jplus.pojo.queryVo.JsjsVo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JSJSMapper {
    Integer getGzl(@Param("teacherCompetitioncategory") Integer teacherCompetitioncategory);

    void addJSJS(JSJS jSJS);

    /*List<JSJS> getTeacherCompetitionList(@Param("gh") String gh, @Param("nd") Integer nd);*/

    void addZDXSLW(ZDXSLW zDXSLW);

    Float getAllGzl(@Param("gh") String gh, @Param("nd") Integer nd);

    Float getAllLwGzl(@Param("gh") String gh, @Param("nd") Integer nd);

    void remove(@Param("id") Integer id);

    void updateZDXSLW(ZDXSLW zDXSLW);

    List<JsjsVo> getTeacherCompetitionList(@Param("gh") String gh, @Param("nd") Integer nd);

    String getcompetitionLevelByBM(@Param("jsdjbm") Integer jsdjbm);
}
