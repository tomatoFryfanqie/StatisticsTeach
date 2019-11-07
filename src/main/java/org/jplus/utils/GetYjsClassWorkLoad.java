package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
public class GetYjsClassWorkLoad {

    /**
     *
     * @param jhxs  计划学时
     * @param bzrs  标准人数
     * @param skrs  上课人数
     * @return
     */
    public static Float getYjsClassWorkLoad(Integer jhxs,Integer bzrs,Integer skrs){
        Float getWork = 0.0f;

        /*判断人数*/
        if(skrs<=bzrs){
                getWork = (float)jhxs*1.5f;
        }else{
            getWork = (float)jhxs*1.5f*(1.0f+(float)((skrs-bzrs)/skrs));
        }
        return getWork;
    }
}
