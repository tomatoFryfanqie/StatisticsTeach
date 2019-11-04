package org.jplus.pojo.basisInfo;

import lombok.Data;
import org.jplus.pojo.Users;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.pojo
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
/*教师的基本信息*/
@Data
public class Jbxx {
    /*教师基本信息id*/
    private Integer jbxxid;
    /*工号*/
    private Users users;
    /*院系*/
    private Yxbm yxbm;
    /*职务*/
    private Zwbm zwbm;
    /*职称*/
    private Zcbm zcbm;
    /*岗位类型*/
    private Gwlxbm gwlxbm;
    /*是否新入职,0,1表示*/
    private Integer sfxrz;
    /*教师额定工作量*/
    private Float edgzl;
    /*本科生最低授课*/
    private Float bkszdsk;
}
