package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.JSJS;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
import org.jplus.service.JSJSService;
import org.jplus.service.ZDXSJSService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 13:09
 */
@Controller
public class UndergraduateKnowledgeContestController {

    @Autowired
    private ZDXSJSService zDXSJSService;

    @Autowired
    private JSJSService jSJSService;

    @RequestMapping("/know")
    @NeedLogin
    public String hello(Model model) {
        List<JSJS> result = jSJSService.getTeacherCompetitionList();
        List<ZDXSJS> list = zDXSJSService.getStudentCompetitionList();
        model.addAttribute("allStudentCompetitionList", list);
        model.addAttribute("allTeacherCompetitionList", result);
        return "knowledgecontest";
    }

    @NeedLogin
    @RequestMapping("/getYearNum")
    @ResponseBody
    public int getYear() {
        return DateUtils.getCurrentYear();
    }

    @NeedLogin
    @RequestMapping("/addCompetition")
    @ResponseBody
    public void addStudentContest(String contestName, int competition,  int contestLevel, int studentNum, Users users) {
        /**
         * 通过竞赛名称contestName、竞赛类别competitionform和指导学生人数studentNum来获取gzl
         * */
        ZDXSJS zDXSJS = new ZDXSJS();
        // 这里的工号可以从session中获取
        String gh = users.getGh();
        zDXSJS.setGh(gh);
        zDXSJS.setNd(DateUtils.getCurrentYear());
        zDXSJS.setJsmc(contestName);
        zDXSJS.setJslbbm(competition);
        zDXSJS.setJsjbbm(contestLevel);
        zDXSJS.setZdxsrs(studentNum);
        /**
         * 根据传过来的competition、contestLevel来确定工作量
         *      setGzl = 工作量 * studentNum
         *      测试成功
         * */
        float gzl = zDXSJSService.getGzl(competition, contestLevel);
        gzl = gzl * studentNum;
        System.out.println(gzl);
        zDXSJS.setGzl(gzl);
        // 添加到数据库
        zDXSJSService.addZDXSJS(zDXSJS);
    }

    /**
     * 初始化的时候查询数据库并返回指导学生竞赛的信息
     * 测试成功
     * */
    /*@RequestMapping("/getStudentCompetitionList")
    public String getStudentCompetitionList(Model model) {
        List<ZDXSJS> list = zDXSJSService.getStudentCompetitionList();
        model.addAttribute("allStudentCompetitionList", list);
        return "knowledgecontest";
    }*/

    /**
     * 一下是教师教学能力竞赛获奖情况的工作量统计
     * 测试成功
     * */
    @NeedLogin
    @RequestMapping("/addTeacherCompetition")
    @ResponseBody
    public void addTeacherCompetition(String teacherCompetitionName, int teacherCompetitioncategory, int teacherCompetitionform, Users users) {
        JSJS jSJS = new JSJS();
        // 这里的工号可以从session中获取
        String gh = users.getGh();
        jSJS.setGh(gh);
        jSJS.setNd(DateUtils.getCurrentYear());
        jSJS.setJsmc(teacherCompetitionName);
        jSJS.setJsdjbm(teacherCompetitioncategory);
        jSJS.setJsxsbm(teacherCompetitionform);
        /**
         * 根据传过来的teacherCompetitioncategory（竞赛等级）、teacherCompetitionform（竞赛形式）
         * */
        int gzl = jSJSService.getGzl(teacherCompetitioncategory);
        if(teacherCompetitionform != 1) {
            gzl /= 2;
        }
        jSJS.setGzl(gzl);
        // 添加到数据库
        jSJSService.addJSJS(jSJS);
    }

    /**
     * 初始化的时候查询数据库并返回教师教学能力竞赛的信息
     * 测试成功
     * */
    @NeedLogin
    @RequestMapping("/getTeacherCompetitionList")
    @ResponseBody
    public List<JSJS> getTeacherCompetitionList() {
        return jSJSService.getTeacherCompetitionList();
    }

    /**
     * 教师指导学生学士学位论文获奖的信息
     * */
    @NeedLogin
    @RequestMapping("/saveCount")
    @ResponseBody
    public void save(int slwNum, int xlwNum, Users users) {
        ZDXSLW zDXSLW = new ZDXSLW();
        String gh = users.getGh();
        zDXSLW.setGh(gh);
        zDXSLW.setNd(DateUtils.getCurrentYear());
        zDXSLW.setSylwrs(slwNum);
        zDXSLW.setXylwrs(xlwNum);
        float gzl = slwNum * 30 + xlwNum * 10;
        zDXSLW.setGzl(gzl);
        // 向数据库中插入数据
        jSJSService.addZDXSLW(zDXSLW);
        System.out.println("success");
    }

    /**
     * 获取指导学生竞赛的工作两个小计
     * */
    @NeedLogin
    @RequestMapping("/getStudentCompetitionGzl")
    @ResponseBody
    public float getStudentCompetitionGzl() {
        return zDXSJSService.getAllGzl();
    }

    /**
     * 获取教师技能竞赛的工作量小计
     * */
    @NeedLogin
    @RequestMapping("/getTeacherCompetitionGzl")
    @ResponseBody
    public float getTeacherCompetitionGzl() {
        return jSJSService.getAllGzl();
    }

    /**
     * 获取优秀论文的工作量小计
     * */
    @NeedLogin
    @RequestMapping("/getLwGzl")
    @ResponseBody
    public float getLwGzl() {
        return jSJSService.getAllLwGzl();
    }

    /**
     * 工作量总计
     * */
    @NeedLogin
    @RequestMapping("/getAllGzl")
    @ResponseBody
    public float getAllGzl() {
        System.out.println("hello world");
        return zDXSJSService.getAllGzl() + jSJSService.getAllGzl() + jSJSService.getAllLwGzl();
    }
}
