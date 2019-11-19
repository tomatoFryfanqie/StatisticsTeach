package org.jplus.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @program: StatisticsTeach
 * @description: 审核页面
 * @author: MH
 * @create: 2019-11-19 14:11
 **/
@Mapper
public interface CheckMapper {
    //根据类型编码取出类型名称
    public String getLxmc(int yxbm);
}
