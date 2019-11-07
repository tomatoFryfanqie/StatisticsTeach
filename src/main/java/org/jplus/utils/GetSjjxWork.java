package org.jplus.utils;

import org.jplus.dto.BkssjjxEx;
import org.jplus.pojo.bks.Bkssjjx;
/**
 * @author imlgw.top
 * @date 2019/11/5 7:57
 */
public class GetSjjxWork {

    public static BkssjjxEx getSjjxWork(Bkssjjx bkssjjx){
        //都是直接硬编码？能用就行.jpg
        //直接就硬编码呗？那把这个抽离出来作为单独的表的意义何在？
        BkssjjxEx bkssjjxEx=bkssjjx2Ex(bkssjjx);
        float res=0;
        int sxlx1=bkssjjx.getSxlxbm1();
        int sxts1=bkssjjx.getSxts1();
        res+=getSxlxWork(sxlx1,sxts1);
        int sxlx2=bkssjjx.getSxlxbm2();
        int sxts2=bkssjjx.getSxts2();
        res+=getSxlxWork(sxlx2,sxts2);
        int sxlx3=bkssjjx.getSxlxbm3();
        int sxts3=bkssjjx.getSxts3();
        res+=getSxlxWork(sxlx3,sxts3);
        bkssjjxEx.setZdsxgzl(res);
        //微格式讲
        int wgsj=bkssjjx.getWgsjrs()*2;
        res+=wgsj;
        bkssjjxEx.setWgsjgzl(wgsj);
        //毕业论文
        int lwbm=bkssjjx.getZylxbm();
        int rs=bkssjjx.getZdlwrs();
        float lwgzl=0;
        if (lwbm==1){
            lwgzl+=(rs>=10?80:rs*8);
        }if (lwbm==2){
            lwgzl+=(rs>=8?72:rs*9);
        }if (lwbm==3){
            lwgzl+=(rs>=8?80:rs*10);
        }if (lwbm==4){
            lwgzl+=(rs>=6?90:rs*15);
        }
        bkssjjxEx.setZdlwgzl(lwgzl);
        res+=lwgzl;
        //管理工作量
        float glgzl=bkssjjx.getGlgzl();
        bkssjjxEx.setGlgzl(glgzl);
        //总工作量
        res+=glgzl;
        bkssjjxEx.setGzl(res);
        return bkssjjxEx;
    }

    public static BkssjjxEx bkssjjx2Ex(Bkssjjx bkssjjx) {
        BkssjjxEx bkssjjxEx = new BkssjjxEx();
        bkssjjxEx.setGh(bkssjjx.getGh());
        bkssjjxEx.setBkssjjxid(bkssjjx.getBkssjjxid());
        bkssjjxEx.setNd(bkssjjx.getNd());
        bkssjjxEx.setGlnr(bkssjjx.getGlnr());
        bkssjjxEx.setGzl(bkssjjx.getGzl());
        bkssjjxEx.setSxlxbm1(bkssjjx.getSxlxbm1());
        bkssjjxEx.setSxlxbm2(bkssjjx.getSxlxbm2());
        bkssjjxEx.setSxlxbm3(bkssjjx.getSxlxbm3());
        bkssjjxEx.setSxts1(bkssjjx.getSxts1());
        bkssjjxEx.setSxts2(bkssjjx.getSxts2());
        bkssjjxEx.setSxts3(bkssjjx.getSxts3());
        bkssjjxEx.setWgsjrs(bkssjjx.getWgsjrs());
        bkssjjxEx.setZdlwrs(bkssjjx.getZdlwrs());
        bkssjjxEx.setZylxbm(bkssjjx.getZylxbm());
        bkssjjxEx.setGlgzl(bkssjjx.getGlgzl());
        return  bkssjjxEx;
    }

    private static float getSxlxWork(int sxlxbm,int sxts){
        float res=0;
        if (sxlxbm==1){
            res+=sxts*4;
        }else if (sxlxbm==2){
            res+=sxts*1;
        }else if (sxlxbm>=3){
            res+=sxts*2;
        }
        return  res;
    }
}
