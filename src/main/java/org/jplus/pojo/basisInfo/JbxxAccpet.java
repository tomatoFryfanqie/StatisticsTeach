package org.jplus.pojo.basisInfo;

import lombok.Data;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.pojo.basisInfo
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */

/*用来接收前台数据*/
@Data
public class JbxxAccpet {
    /*基本信息id*/
    private Integer jbxxid;
    /*工号*/
    private String gh;
    /*院系编码*/
    private Integer yxbm;
    /*职务编码*/
    private Integer zwbm;
    /*职称编码*/
    private Integer zcbm;
    /*岗位类型编码*/
    private Integer gwlxbm;
    /*是否新入职*/
    private Integer sfxrz;
    /*额定工作量*/
    private Float edgzl;
    /*本科生最低授课*/
    private Float bkszdsk;
}
