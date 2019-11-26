package org.jplus.service;

import org.jplus.mapper.CheckMapper;
import org.jplus.pojo.QTJXGZ;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.check.BkssjjxInfo;
import org.jplus.pojo.check.YjssjjxInfo;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public BkssjjxInfo getBKSSJJXInfo(String gh) {
        System.out.println("获取BKSSJJXInfo");
        BkssjjxInfo bkssjjxInfo = checkMapper.getBKSSJJXInfo(gh);
        System.out.println(bkssjjxInfo.toString());
      //  System.out.println("list：");
       // //bkssjjxInfo.getList().forEach(System.out::println);
        return checkMapper.getBKSSJJXInfo(gh);
    }

    @Override
    public YJSQTJX getYJSQTJXInfo(String gh) {
        return checkMapper.getYJSQTJXInfo(gh);
    }

    @Override
    public ZDXSLW getZDXSLWInfo(String gh) {
        return checkMapper.getZDXSLWInfo(gh);
    }

    @Override
    public QTJXGZ getQTJXGZInfo(String gh) {
        return checkMapper.getQTJXGZInfo(gh);
    }

    @Override
    public ZDSSLW getZDSSLWInfo(String gh) {
        return checkMapper.getZDSSLWInfo(gh);
    }

    @Override
    public YjssjjxInfo getYJSSJJXInfo(String gh) {
        return checkMapper.getYJSSJJXInfo(gh);
    }

    @Override
    public Float getZdxsjsGzl(String gh) {
        return checkMapper.getZdxsjsGzl(gh);
    }

    @Override
    public Float getYjsZdxsjsGzl(String gh) {
        System.out.println("研究生工作量" + checkMapper.getYjsZdxsjsGzl(gh));
        return checkMapper.getYjsZdxsjsGzl(gh);
    }

    @Override
    public Float getJsjsGzl(String gh) {
        return checkMapper.getJsjsGzl(gh);
    }
}
