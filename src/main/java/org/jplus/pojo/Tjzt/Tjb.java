package org.jplus.pojo.Tjzt;

import lombok.Data;

/**
 * @author imlgw.top
 * @date 2019/11/19 17:35
 */

/*
*   insert into tjb(nd,gh,xm,zw,yxmc,edgzl,bkszdsk,bksktgzl,bkssjgzl,
                zlgcgzl,jxcggzl,bkszxxmgzl,bkshxxmgzl,jcgzl,jxgggzl,bksjsgzl,
                jsjsgzl,bkslwgzl,bksqtgzl,bkszgzl,yjsktjxgzl,yjssjjxgzl,xkjsgzl,
                yjsjyxmgzl,yjshxxmgzl,yjslwgzl,yjsqtgzl,yjszgzl,
                sjjxgzl,bksskwwc,edjxwwc,shrgh)
    values(t_nd,t_gh,t_xm,t_zw,t_yxmc,t_edgzl,t_bkszdsk,t_bksktgzl,t_bkssjgzl,
    t_zlgcgzl,t_jxcggzl,t_bkszxxmgzl,t_bkshxxmgzl,t_jcgzl,t_jxgggzl,t_bksjsgzl,
    t_jsjsgzl,t_bkslwgzl,t_bksqtgzl,t_bkszgzl,t_yjsktjxgzl,t_yjssjjxgzl,t_xkjsgzl,
    t_yjsjyxmgzl,t_yjshxxmgzl,t_yjslwgzl,t_yjsqtgzl,t_yjszgzl,
    t_sjjxgzl,t_bkshskwwc,t_edjxwwc,p_gh);
* */


@Data
public class Tjb {
    private Integer nd;
    private String gh;
    private String xm;
    private String zw;
    private String yxmc;
    //额定工作量
    private Float edgzl;
    //本科生最低授课
    private Float bkszdsk;
    //本科生课堂工作量
    private Float bksktgzl;
    /*本科生事件教学工作量*/
    private Float bkssjgzl;
    //质量工程工作狼
    private Float zlgcgzl;
    //教学成果工作量
    private Float jxcggzl;
    //..
    private Float bkszxxmgzl;
    //..
    private Float bkshxxmgzl;
    //较菜工作量
    private Float jcgzl;
    //教学改革工作量
    private Float jxgggzl;
    //本科生竞赛工作量
    private Float bksjsgzl;
    //的教师竞赛
    private Float jsjsgzl;
    //本科生论文
    private Float bkslwgzl;
    //本科生其他
    private Float bksqtgzl;
    //本科生总工作量
    private  Float bkszgzl;
    //研究生课堂教学工作量
    private Float yjsktjxgzl;
    //研究生实践教学工作量
    private Float jsjsjjxgzl;
    //学科建设工作量
    private Float xkjsgzl;
    //研究生教研项目据工作量
    private Float yjsjyxmgzl;
    //yjshxxmgzl
    private Float yjshxxmgzl;
    //yjslwgzl
    private Float yjslwgzl;

    private Float yjsjsgzl;
    //yjsqtgzl
    private Float yjsqtgzl;
    //yjszgzl
    private Float yjszgzl;
    //sjjxgzl
    private Float sjjxgzl;
    //bksskwwc
    private Float bksskwwc;
    //edjxwwc
    private Float edjxwwc;
    //shrgh
    private Integer shrgh;

}
