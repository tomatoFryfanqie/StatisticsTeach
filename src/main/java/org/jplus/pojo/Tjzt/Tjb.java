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
    private float edgzl;
    //本科生最低授课
    private float bkszdsk;
    //本科生课堂工作量
    private float bksktgzl;
    //质量工程工作狼
    private float zlgcgzl;
    //教学成果工作量
    private float jxcggzl;
    //..
    private float bkszxxmgzl;
    //..
    private float bkshxxmgzl;
    //较菜工作量
    private float jcgzl;
    //教学改革工作量
    private float jxgggzl;
    //本科生竞赛工作量
    private float bksjsgzl;
    //的教师竞赛
    private float jsjsgzl;
    //本科生论文
    private float bkslwgzl;
    //本科生其他
    private float bksqtgzl;
    //本科生总工作量
    private  float bkszgzl;
    //研究生课堂教学工作量
    private float yjsktjxgzl;
    //研究生实践教学工作量
    private float yjssjjxgzl;
    //学科建设工作量
    private float xkjsgzl;
    //研究生教研项目据工作量
    private float yjsjyxmgzl;
    //yjshxxmgzl
    private float yjshxxmgzl;
    //yjslwgzl
    private float yjslwgzl;
    //yjsqtgzl
    private float yjsqtgzl;
    //yjszgzl
    private float yjszgzl;
    //sjjxgzl
    private float sjjxgzl;
    //bksskwwc
    private float bksskwwc;
    //edjxwwc
    private float edjxwwc;
    //shrgh
    private float shrgh;

}
