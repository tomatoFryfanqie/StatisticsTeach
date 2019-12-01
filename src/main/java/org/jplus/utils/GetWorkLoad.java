package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils
 * @Author: lzh
 * @CreateTime: 2019/12/1
 * @Description: Description
 */
public class GetWorkLoad {

    /*获得额定教学工作量*/
    /**
     *
     * @param zcbm      职称编码
     * @param gwlxbm    岗位类型编码
     * @param sfxrz     是否新入职 0为是，1为否
     * @return
     */
    public static Float getRatedWorkload(Integer zcbm,Integer gwlxbm,Integer sfxrz){
        Float getWorkLoad = 0.0f;
        if(zcbm==3||zcbm==4){
            if (zcbm==3){
                if (sfxrz==0){
                    getWorkLoad = 140.0f;
                }else {
                    getWorkLoad = 280.0f;
                }
            }else {
                if (sfxrz==0){
                    getWorkLoad = 100.0f;
                }else {
                    getWorkLoad = 200.0f;
                }
            }
        }else{
            if (zcbm==1) {
                switch (gwlxbm) {
                    case 1:
                        getWorkLoad = 330f;
                        break;
                    case 2:
                        getWorkLoad = 260f;
                        break;
                    case 3:
                        getWorkLoad = 80f;
                        break;
                }
            }
            if (zcbm==2){
                switch (gwlxbm) {
                    case 1:
                        getWorkLoad = 360f;
                        break;
                    case 2:
                        getWorkLoad = 280f;
                        break;
                    case 3:
                        getWorkLoad = 100f;
                        break;
                }
            }
        }
        return getWorkLoad;
    }

    /*获得本科生课堂教学工作量*/
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
