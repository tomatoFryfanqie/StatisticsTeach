package org.jplus.pojo.jbjsyxkjs;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JBJSYXKJSAccept {
    //主键
    private Integer xkjsid;
    //工号
    private String gh;
    //年度
    private Integer nd;
    //是否撰写培养方案
    private Integer sfzxpyfa;
    //课堂大纲门数
    private Integer  kddgms;
    //实验大纲门数
    private Integer sydgms;
    //工作量
    private Float gzl;
}
