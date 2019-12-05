package org.jplus.service;

import org.jplus.pojo.jbjsyxkjs.JBJSYXKJS;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJSAccept;
import org.springframework.stereotype.Service;


@Service
public interface JbjsyxkjsService {

    //添加基本建设和学科建设信息
    public void addGraduateConstruction(JBJSYXKJSAccept jbjsyxkjsAccept);

    //根据工号取出基本建设和学科建设信息
    public JBJSYXKJS getJBJSYXKJSInfo(String gh);

    //根据工号取出工作量
    public Float getWorkLoad(String gh);

    //修改基本建设和学科建设信息
    public void updateGraduateConstruction(JBJSYXKJSAccept jbjsyxkjsAccept);
}
