package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils
 * @Author: lzh
 * @CreateTime: 2019/11/1
 * @Description: Description
 */
/*
* 获取额定教学工作量
* */
public class GetRatedWorkload {
    public static Float getRatedWorkload(Integer zcbm,Integer gwlxbm,Integer sfxrz){

        Float getWorkLoad = 0.0f;
        /*如果新入职 且为职称为初级或者中级*/
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
}