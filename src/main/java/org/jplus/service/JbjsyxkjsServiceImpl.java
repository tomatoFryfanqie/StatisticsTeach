package org.jplus.service;

import org.jplus.mapper.JBJSYXKJSMapper;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJS;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJSAccept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JbjsyxkjsServiceImpl implements JbjsyxkjsService{
    @Autowired
    JBJSYXKJSMapper jbjsyxkjsMapper;

    @Override
    public void addGraduateConstruction(JBJSYXKJSAccept jbjsyxkjsAccept) {
        jbjsyxkjsMapper.addJBJSYXKJS(jbjsyxkjsAccept);
    }

    @Override
    public JBJSYXKJS getJBJSYXKJSInfo(String gh) {

        return jbjsyxkjsMapper.getJBJSYXKJS(gh);
    }

    @Override
    public Float getWorkLoad(String gh) {
        return jbjsyxkjsMapper.getGzlByGh(gh);
    }

    @Override
    public void updateGraduateConstruction(JBJSYXKJSAccept jbjsyxkjsAccept) {
        jbjsyxkjsMapper.updateaddJBJSYXKJS(jbjsyxkjsAccept);
    }
}
