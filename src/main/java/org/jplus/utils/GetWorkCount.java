package org.jplus.utils;

import org.jplus.service.JxcgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 计算工作量
 * @author:zmj
 * @date 2019/11/415:08
 */
public class GetWorkCount {
//工作量获取
    public static Float GetWorkCount(int xmzrs, int xmpm, int xmfs) {
//项目权重
        Float xmqz = 0.0f;
        if (xmzrs == 1 && xmpm == 1) {
            xmqz = 1.0f;
        } else if (xmzrs == 2 && xmpm == 1) {
            xmqz = 0.7f;
        } else if (xmzrs == 2 && xmpm == 2) {
            xmqz = 0.3f;
        } else if (xmzrs == 3 && xmpm == 1) {
            xmqz = 0.7f;
        } else if (xmzrs == 3 && xmpm == 2) {
            xmqz = 0.2f;
        } else  {
            if (xmpm == 1) xmqz = 0.6f;
            else if (xmpm == 2) xmqz = 0.2f;
            else if (xmpm == 3) xmqz = 0.1f;
            else xmqz = (float) 0.1 / (xmzrs - 3);
        }
        return xmfs * xmqz;
    }

    //横向工作量获取
    public static Float GetHxWorkCount(int dzjf) {
        return (float) Math.ceil((0.001 * dzjf));
    }
}
