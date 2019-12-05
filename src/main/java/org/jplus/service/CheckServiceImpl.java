package org.jplus.service;

import org.jplus.mapper.CheckMapper;
import org.jplus.pojo.undergraduateCompatitonAndOther.QTJXGZ;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSLW;
import org.jplus.pojo.check.BkssjjxInfo;
import org.jplus.pojo.check.YjssjjxInfo;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class CheckServiceImpl implements CheckService{
    @Autowired
    CheckMapper checkMapper;

    @Override
    public String getLxmcByGh(String gh) {
        return checkMapper.getLxmcByGh(gh);
    }

    @Override
    public String getYxmc(Integer yxbm) {
        return checkMapper.getLxmc(yxbm);
    }

    @Override
    public BkssjjxInfo getBKSSJJXInfo(String gh) {
        BkssjjxInfo bkssjjxInfo = checkMapper.getBKSSJJXInfo(gh);
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
        return checkMapper.getYjsZdxsjsGzl(gh);
    }

    @Override
    public Float getJsjsGzl(String gh) {
        return checkMapper.getJsjsGzl(gh);
    }

    @Override
    public void clearTjztAndShzt(String gh) {
        checkMapper.clearTjztAndShzt(gh);
    }

    @Override
    public void setShztByDepartments(String gh, String userName, Timestamp date) {
        checkMapper.setShztByDepartments(gh,userName,date);
    }


    @Override
    public void setShztByOffice(String gh, String userName, Timestamp date){
        checkMapper.setShztByOffice(gh,userName,date);
    }

    @Override
    public void setShrgh(String gh, String shrgh) {
        checkMapper.setShrgh(gh,shrgh);
    }


}
