package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 14:51
 */
@Repository
public interface ZDXSJSMapper {

    void addZDXSJS(ZDXSJS zDXSJS);

    List<ZDXSJS> getStudentCompetitionList(@Param("gh") String gh, @Param("nd") int nd);

    float getGzl(@Param("competition") int competition, @Param("contestLevel") int contestLevel);

    float getAllGzl(@Param("gh") String gh, @Param("nd") int nd);

    void remove(@Param("id") Integer id);

    ZDXSLW findZDXSLWByGhAndYear(@Param("gh") String gh, @Param("nd") int nd);

    List<ZDXSJS> getStudentCompetitionList2(@Param("gh") String gh, @Param("nd") int nd);

    float getAllGzl2(@Param("gh") String gh, @Param("nd") int nd);

    int isOnlyForOneYear(@Param("gh") String gh, @Param("nd") int nd);
}
