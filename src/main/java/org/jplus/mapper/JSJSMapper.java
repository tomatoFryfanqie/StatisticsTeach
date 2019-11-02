package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.JSJS;
import org.jplus.pojo.ZDXSLW;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 18:54
 */
@Repository
public interface JSJSMapper {
    int getGzl(@Param("teacherCompetitioncategory") int teacherCompetitioncategory);

    void addJSJS(JSJS jSJS);

    List<JSJS> getTeacherCompetitionList();

    void addZDXSLW(ZDXSLW zDXSLW);

    float getAllGzl();

    float getAllLwGzl();
}
