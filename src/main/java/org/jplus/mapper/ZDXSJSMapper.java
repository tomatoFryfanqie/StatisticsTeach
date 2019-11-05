package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.ZDXSJS;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 14:51
 */
@Repository
public interface ZDXSJSMapper {

    void addZDXSJS(ZDXSJS zDXSJS);

    List<ZDXSJS> getStudentCompetitionList();

    float getGzl(@Param("competition") int competition, @Param("contestLevel") int contestLevel);

    float getAllGzl();
}
