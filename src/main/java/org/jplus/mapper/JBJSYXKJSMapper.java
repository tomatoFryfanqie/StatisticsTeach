package org.jplus.mapper;

import org.jplus.pojo.jbjsyxkjs.JBJSYXKJS;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJSAccept;

/**
 * @program: StatisticsTeach
 * @description: 教学基本建设与学科建设工作 Dao
 * @author: MH
 * @create: 2019-11-08 23:48
 **/
public interface JBJSYXKJSMapper {
    //添加教学基本建设与学科建设信息
    public void addJBJSYXKJS(JBJSYXKJSAccept jbjsyxkjsAccept);
    //根据工号取出教学基本建设与学科建设信息
    public JBJSYXKJS getJBJSYXKJS(String gh);
    //根据工号取出工作量
    public Float getGzlByGh(String gh);
    //根据工号更新数据
    public void updateaddJBJSYXKJS(JBJSYXKJSAccept jbjsyxkjsAccept);
}
