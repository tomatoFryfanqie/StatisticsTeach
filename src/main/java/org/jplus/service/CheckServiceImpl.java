package org.jplus.service;

import org.jplus.mapper.CheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: StatisticsTeach
 * @description: 审核界面的业务处理类的实现
 * @author: MH
 * @create: 2019-11-19 14:18
 **/
@Component
public class CheckServiceImpl implements CheckService{
    @Autowired
    CheckMapper checkMapper;
    @Override
    public String getYxmc(int yxbm) {
        return checkMapper.getLxmc(yxbm);
    }
}
