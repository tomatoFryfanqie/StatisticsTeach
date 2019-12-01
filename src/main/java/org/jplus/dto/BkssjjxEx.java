package org.jplus.dto;

import lombok.Getter;
import lombok.Setter;
import org.jplus.pojo.bks.Bkssjjx;

/**
 * @author imlgw.top
 * @date 2019/11/5 8:30
 * 能用就行?.jpg
 */
@Getter@Setter
public class BkssjjxEx extends Bkssjjx{

    /*
    * 对Bkssjjx的扩展封装，用于返回给页面
    *
    * */
    private float zdsxgzl;
    private float wgsjgzl;
    private float zdlwgzl;
}
