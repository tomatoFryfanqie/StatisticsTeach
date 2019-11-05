package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils.getclassworkload
 * @Author: lzh
 * @CreateTime: 2019/11/1
 * @Description: Description
 */
public class GetClassWork {
    /**
     *
     * @param jhxs  教学学时
     * @param sfsy  是否双语
     * @param bzrs  标准人数
     * @param skrs  上课人数
     * @return      返回工作量
     */
    public static Float getClassWork(Integer jhxs,Integer sfsy,Integer bzrs,Integer skrs){

        Float getWork = 0.0f;

        /*判断人数*/
        if(skrs<=bzrs){
            if (sfsy==1){
                getWork = (float)jhxs*1.5f;
            }
            else {
                getWork = (float)jhxs*1.0f;
            }
        }else {
            if (sfsy==1){
                getWork = (float)jhxs*1.5f*(1.0f+(float)((skrs-bzrs)/skrs));
            }else {
                getWork = (float)jhxs*1.0f*(1.0f+(float)((skrs-bzrs)/skrs));
            }
        }

        return getWork;
    }
}
