package org.jplus.utils;

import org.jplus.dto.BkssjjxEx;
import org.jplus.pojo.bks.Bkssjjx;
import org.springframework.beans.BeanUtils;

/**
 * @author imlgw.top
 * @date 2019/11/5 7:57
 */
@Deprecated
public class GetSjjxWork {

    public static BkssjjxEx getSjjxWork(Bkssjjx bkssjjx){
        //扩展类封装
        BkssjjxEx bkssjjxEx=new BkssjjxEx();
        BeanUtils.copyProperties(bkssjjx,bkssjjxEx);
        //计算
        float res=0;
        //计算第一个实习类型工作量
        int sxlx1=bkssjjx.getSxlxbm1();
        int sxts1=bkssjjx.getSxts1();
        res+=getSxlxWork(sxlx1,sxts1);

        //计算第二个实习类型工作量
        int sxlx2=bkssjjx.getSxlxbm2();
        int sxts2=bkssjjx.getSxts2();
        res+=getSxlxWork(sxlx2,sxts2);

        //计算第三个实习类型工作量
        int sxlx3=bkssjjx.getSxlxbm3();
        int sxts3=bkssjjx.getSxts3();
        res+=getSxlxWork(sxlx3,sxts3);
        bkssjjxEx.setZdsxgzl(res); /*设置指导实习总工作量*/

        //微格式讲工作量
        int wgsj=bkssjjx.getWgsjrs()*2; /* 微格式讲人数*2 */
        res+=wgsj;
        bkssjjxEx.setWgsjgzl(wgsj); /*设置微格式讲工作量*/

        //毕业论文工作量
        int lwbm=bkssjjx.getZylxbm(); //专业类型：文，理，工，留学
        int rs=bkssjjx.getZdlwrs(); //指导人数
        float lwgzl=0;
        if (lwbm==1){
            lwgzl+=(rs>=10?80:rs*8); //文科：超过10人不计分数
        }if (lwbm==2){
            lwgzl+=(rs>=8?72:rs*9); //理科：超过8人不记分
        }if (lwbm==3){
            lwgzl+=(rs>=8?80:rs*10); //工科：超过8人不记分
        }if (lwbm==4){
            lwgzl+=(rs>=6?90:rs*15); //留学生：超过6人不记分
        }
        res+=lwgzl;
        bkssjjxEx.setZdlwgzl(lwgzl); /*设置指导毕业论文工作量*/

        //管理工作量
        float glgzl=bkssjjx.getGlgzl();
        bkssjjxEx.setGlgzl(glgzl); /*设置管理工作量*/

        //总工作量
        res+=glgzl;
        bkssjjxEx.setGzl(res); /*设置总工作量*/
        return bkssjjxEx;
    }


    /**
     * @param sxlxbm
     * @param sxts
     * @return 各个实习类型对应实习天数的工作量
     */
    private static float getSxlxWork(int sxlxbm,int sxts){
        float res=0;
        if (sxlxbm==1){ /*驻点实习 4分/天*/
            res+=sxts*4;
        }else if (sxlxbm==2){ /*非驻地实习 1分/天*/
            res+=sxts*1;
        }else if (sxlxbm>=3){ /*其他实习 2分天*/
            res+=sxts*2;
        }
        return  res;
    }
}
