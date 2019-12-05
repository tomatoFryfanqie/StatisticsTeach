package org.jplus.dto;

import lombok.Getter;
import lombok.Setter;
import org.jplus.pojo.bks.Bkssjjx;


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
