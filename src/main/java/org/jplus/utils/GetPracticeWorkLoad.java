package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils
 * @Author: lzh
 * @CreateTime: 2019/11/9
 * @Description: Description
 */
public class GetPracticeWorkLoad {

    /**
     *
     * @param sjts1 实践天数1
     * @param sjts2 实践天数2
     * @param sjts3 实践天数3
     * @return
     */
    public static Float getDayWorkLoad(Integer sjts1,Integer sjts2,Integer sjts3){

        Float getWork = 0.0f;
        getWork =  (float)sjts1*2+sjts2*2+sjts3*2;
        return getWork;
    }

    /**
     *
     * @param zdxshdcs  指导学生活动次数
     * @return
     */
    public static Float getForYjsWorkLoad(Integer zdxshdcs){
        Float getWork = 0.0f;
        getWork = (float)zdxshdcs*1;
        return getWork;
    }
}
