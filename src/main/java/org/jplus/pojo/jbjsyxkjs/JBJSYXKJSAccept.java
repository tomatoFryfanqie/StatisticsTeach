package org.jplus.pojo.jbjsyxkjs;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: StatisticsTeach
 * @description: 接收表单数据的实体
 * @author: MH
 * @create: 2019-11-08 22:20
 **/
@Getter
@Setter
public class JBJSYXKJSAccept {
    //主键
    private int xkjsid;
    //工号
    private String gh;
    //年度
    private int nd;
    //是否撰写培养方案
    private int sfzxpyfa;
    //课堂大纲门数
    private int  kddgms;
    //实验大纲门数
    private int sydgms;
    //工作量
    private float gzl;
    @Override
    public String toString() {
        return "JBJSYXKJSAccept{" +
                "工号=" + gh + '\'' +
                ", 年度=" + nd +
                ", 是否撰写培养方案=" + sfzxpyfa + '\'' +
                ", 课堂大纲门数=" + kddgms + '\'' +
                ", 实验大纲门数=" + sydgms +
                ",工作量=" + gzl +
                '}';
    }
}
