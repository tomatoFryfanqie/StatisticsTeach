package org.jplus.pojo.checkgzl;

import lombok.Data;

/**
 * @description:审核工作量1表格实体
 * @author:zmj
 * @date 2019/11/1617:37
 */
@Data
public class Checkgzl {
    //工号
    private String gh;

    //姓名
    private String uname;

    //职务
    private String zw;

    //额定工作量
    private float edgzl;

    //本科生教学工作量
    private float bksgzl;

    //研究生教学工作量
    private float yjsgzl;

    //总工作量量
    private float allgzl;

    //审核状态
    private Integer shzt;
}
