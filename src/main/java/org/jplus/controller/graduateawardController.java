package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.jplus.service.JSJSService;
import org.jplus.service.ZDSSLWService;
import org.jplus.service.ZDXSJSService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wb
 * @date 2019/11/8 - 9:38
 */
@Controller
public class graduateawardController {

    @Autowired
    private ZDXSJSService zDXSJSService;

    @Autowired
    private ZDSSLWService zDSSLWService;

    @NeedLogin
    @RequestMapping("/masterKnow")
    public String hello(Model model) {
        List<ZDXSJS> list = zDXSJSService.getStudentCompetitionList();
        model.addAttribute("allStudentCompetitionList", list);
        return "graduateaward";
    }

    @NeedLogin
    @RequestMapping("/addMasterCompetition")
    @ResponseBody
    public void addMasterStudentContest(String contestName, int competition,  int contestLevel, int studentNum, Users users) {
        ZDXSJS zDXSJS = new ZDXSJS();
        // 这里的工号可以从session中获取
        String gh = users.getGh();
        zDXSJS.setGh(gh);
        zDXSJS.setNd(DateUtils.getCurrentYear());
        zDXSJS.setJsmc(contestName);
        zDXSJS.setJslbbm(competition);
        zDXSJS.setJsjbbm(contestLevel);
        zDXSJS.setZdxsrs(studentNum);
        float gzl = zDXSJSService.getGzl(competition, contestLevel);
        gzl = gzl * studentNum;
        System.out.println(gzl);
        zDXSJS.setGzl(gzl);
        // 添加到数据库
        zDXSJSService.addZDXSJS(zDXSJS);
    }

    @NeedLogin
    @RequestMapping("/saveMasterCount")
    @ResponseBody
    public void save(int slwNum, int xlwNum, Users users) {
        ZDSSLW zDSSLW = new ZDSSLW();
        String gh = users.getGh();
        zDSSLW.setGh(gh);
        zDSSLW.setNd(DateUtils.getCurrentYear());
        zDSSLW.setSylwrs(slwNum);
        zDSSLW.setXylwrs(xlwNum);
        float gzl = slwNum * 50 + xlwNum * 10;
        zDSSLW.setGzl(gzl);
        zDSSLWService.addZDSSLW(zDSSLW);
        System.out.println("success");
    }

    @NeedLogin
    @RequestMapping("/getMasterLwGzl")
    @ResponseBody
    public float getLwGzl() {
        return zDSSLWService.getAllMasterLwGzl();
    }

    @NeedLogin
    @RequestMapping("/getMasterStudentCompetitionGzl")
    @ResponseBody
    public float getMasterStudentCompetitionGzl() {
        return zDXSJSService.getAllGzl();
    }

    @NeedLogin
    @RequestMapping("/getMasterAllGzl")
    @ResponseBody
    public float getAllGzl() {
        System.out.println("hello world");
        return zDXSJSService.getAllGzl() + zDSSLWService.getAllMasterLwGzl();
    }
}
