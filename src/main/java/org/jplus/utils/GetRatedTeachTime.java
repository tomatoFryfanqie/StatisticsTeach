package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils
 * @Author: lzh
 * @CreateTime: 2019/11/1
 * @Description: Description
 */
public class GetRatedTeachTime {

    public static Float getTeachTime(Integer zcbm,Integer gwlxbm){

        Float getTime = 0.0f;

        if(zcbm==3||zcbm==4){
            getTime = 96.0f;
        }else {
                switch (gwlxbm){
                    case 1 :
                        getTime = 160.0f; break;
                    case 2 :
                        getTime = 96.0f; break;
                    case 3 :
                        getTime = 32.0f; break;
                }
            }
        return getTime;
    }
}
