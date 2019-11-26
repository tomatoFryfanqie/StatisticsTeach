package org.jplus.pojo.jbjsyxkjs;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: StatisticsTeach
 * @description: 基本建设与学科建设实体类
 * @author: MH
 * @create: 2019-11-08 15:29
 **/
/*
   `xkjsid` int(11) NOT NULL AUTO_INCREMENT,
  `gh` char(8)   COMMENT '工号',
  `nd` int(4)  COMMENT '年度',
  `sfzxpyfa` int(1)  COMMENT '是否撰写培养方案 0：未写 1：写',
  `kddgms` int(2)  COMMENT '编写课堂大纲门数',
  `sydgms` int(2)  COMMENT '实验大纲门数',
  `gzl` float(8,1)  COMMENT '工作量',
*/
@Data
public class JBJSYXKJS {
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
