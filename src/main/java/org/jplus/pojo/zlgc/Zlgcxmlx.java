package org.jplus.pojo.zlgc;

import lombok.Data;


/*
`xmlxbm` int(11) NOT NULL,
`xmlxmc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
*/
@Data
public class Zlgcxmlx {
    //项目类型编码
    private Integer xmlxbm;
    //项目类型名称
    private String xmlxmc;
}
