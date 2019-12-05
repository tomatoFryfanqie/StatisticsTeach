package org.jplus.service;

import org.jplus.pojo.yjsjyxm.Yjshxxm;
import org.jplus.pojo.yjsjyxm.Yjsjyxm;

import java.util.List;


public interface YjsjyxmService {

    List<Yjsjyxm> getYjsjyxm(String gh);


    int delYjsjyxm(Integer id);


    int addYjsjyxm(Yjsjyxm yjsjyxm);


    float getYjsjyxmGzlSum(String gh);


    List<Yjshxxm> getYjshxxm(String gh);


    int delYjshxxm(Integer id);


    int addYjshxxm(Yjshxxm yjshxxm);

    float getYjshxxmGzlSum(String gh);
}
