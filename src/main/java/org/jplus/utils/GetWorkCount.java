package org.jplus.utils;

/**
 * @description: 计算工作量
 * @author:zmj
 * @date 2019/11/415:08
 */
public class GetWorkCount {
    public static Double GetWorkCount(int xmzrs,int xmpm,int xmfs){
//项目权重
        Double xmqz = 0.0;
            if (xmzrs == 1 && xmpm == 1){
                xmqz = 1.0;
            }else if(xmzrs == 2 && xmpm == 1){
                xmqz = 0.7;
            }else if(xmzrs == 2 && xmpm == 2){
                xmqz = 0.3;
            }else if(xmzrs == 3 && xmpm == 1){
                xmqz = 0.7;
            }else if(xmzrs == 3 && xmpm == 2){
                xmqz = 0.2;
            }else{
                if (xmpm == 1) xmqz = 0.6;
                else if (xmpm == 2) xmqz = 0.2;
                else if (xmpm == 3) xmqz = 0.1;
                else xmqz = 0.1/(xmzrs - 3);
            }
        return xmfs * xmqz;
    }

}
