package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.jplus.pojo.queryVo.JsjsVo;
import org.jplus.pojo.queryVo.ZdxsjsVo;
import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.service.*;
import org.jplus.utils.DateUtils;
import org.jplus.utils.GetPracticeWorkLoad;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static org.jplus.utils.GetSjjxWork.getSjjxWork;

/*
 * @author MH
 * @date 2019/11/23 23:30
 *  审核页面控制类，版本 1.0
 */
@Controller
public class TestCheckController {
    //wb 的
    @Autowired
    private ZDSSLWService zDSSLWService;
    @Autowired
    CheckService checkService;
    @Autowired
    private BksktjxService bksktjxService;  // 课堂教学
    @Autowired
    private BkssjjxService bkssjjxService;  // 实践教学
    @Autowired
    ZlgcService zlgcService;                 // 质量工程
    @Autowired
    JxcgServiceImpl jxcgService;             // 教学成果
    @Autowired
    private ZDXSJSService zDXSJSService;    // 教学改革
    @Autowired
    private JSJSService jSJSService;


    // 研究生
    @Autowired
    private YjsktjxService yjsktjxService; // 课堂教学工作量
    @Autowired
    private YjssjjxService yjssjjxService;  // 实践教学
    @Autowired
    JbjsyxkjsService jbjsyxkjsService;      // 教学基本建设与学科建设工作
    @Autowired
    private YjsjyxmService yjsjyxmService;  // 教学研究项目
    @NeedLogin
    @RequestMapping("/testCheck")
    public String getofficedetails(Model model) {
        return "departmentalaudit";
    }
    @NeedLogin
    @PostMapping("/officedetails")
    public String getQualityEngineeringInfo(Model model, Users users) {
        // 将用户的信息取出( 工号， 姓名， 院系编码)
        model.addAttribute("gh", users.getGh());
        model.addAttribute("name", users.getUname());
        /*获取基本信息存到model中*/
        model.addAttribute("department", checkService.getYxmc(users.getYxbm()));
        //本科生教学
        // 1 用户的课堂教学信息   classroomteaching
        model.addAttribute("bksktjx", bksktjxService.getBksktjxInfo(users.getGh()));
        /*获取课堂教学的总工作量*/
        model.addAttribute("bksKtjxgzlSum", bksktjxService.getBkjxgzlSum(users.getGh()));
        // 2 实践教学工作量         practiceteh
        Optional.ofNullable(bkssjjxService.selectBkssjjx(users.getGh())).ifPresent(sjjx -> model.addAttribute
                ("bkssjjx", getSjjxWork(sjjx)));
        model.addAttribute("bkssjjxInfo", checkService.getBKSSJJXInfo(users.getGh()));
        // 3 质量工程工作量        qualityengineering
        model.addAttribute("zlgc", zlgcService.getZlgcInfo());
        //获取质量工程的工作总量
        model.addAttribute("zlgcSumOfWorkload", zlgcService.calculateSumOfWorkLoad(users.getGh()));
        /*  4教学研究              teachingresearch */
        // 教学成果工作量
        //  纵向教研项目工作量
        //  横向教研项目工作量
        //  编写规划教材、教材获奖工作量
        //  教学改革工作量
        model.addAttribute("Jxcgs", jxcgService.getJxcgInfo());
        model.addAttribute("Jxcgdjs", jxcgService.getJxcgdjInfo());

        model.addAttribute("Zxxms", jxcgService.getZxxm());
        model.addAttribute("Zxxmdjs", jxcgService.getZxxmdjInfo());

        model.addAttribute("Hxxms", jxcgService.getHxxm());

        model.addAttribute("Jcs", jxcgService.getJc());
        model.addAttribute("Jcjbs", jxcgService.getJcjbInfo());

        model.addAttribute("Jxggs", jxcgService.getJxgg());
        model.addAttribute("Lxjbs", jxcgService.getLxjbInfo());
        model.addAttribute("year", GetYear.getYears());
//        model.addAttribute("gh", users.getGh());

        model.addAttribute("bksJxcgGzl", jxcgService.getJxcgGzlSun(users.getGh()));
        model.addAttribute("bksZxxmGzl", jxcgService.getZxxmGzlSun(users.getGh()));
        model.addAttribute("bksHxxmGzl", jxcgService.getHxxmGzlSun(users.getGh()));
        model.addAttribute("bksJcGzl", jxcgService.getJcGzlSun(users.getGh()));
        model.addAttribute("bksJxggGzl", jxcgService.getJxggGzlSun(users.getGh()));

        /* 5 教学知识竞赛              know*/
        // TODO 后续自己重写，都不用wb的  学生竞赛和教师竞赛
        List<JsjsVo> result = jSJSService.getTeacherCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        List<ZdxsjsVo> list1 = zDXSJSService.getStudentCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        ZDXSLW zDXSLW = zDXSJSService.findZDXSLWByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        model.addAttribute("allStudentCompetitionList", list1);
        model.addAttribute("allTeacherCompetitionList", result);
        model.addAttribute("zDXSLW", zDXSLW);
        // 本科 指导学生竞赛工作量
        model.addAttribute("ZdxsjsGzl", checkService.getZdxsjsGzl(users.getGh()));
        // 研究生 指导学生竞赛工作量

        model.addAttribute("YjsZdxsjsGzl", checkService.getYjsZdxsjsGzl(users.getGh()));

        model.addAttribute("YjsZdxsjsGzl", checkService.getYjsZdxsjsGzl(users.getGh()));

        // 教师教学能力竞赛获奖工作量
        model.addAttribute("JsjsGzl", checkService.getJsjsGzl(users.getGh()));
        // 教师指导学生学士学位论文获奖工作量
        model.addAttribute("ZDSSLWInfo", checkService.getZDSSLWInfo(users.getGh()));
        /* 6 其它教育教学活动         other*/
        // 教学督导工作量 （可从数据库取）
        // 学生学业指导帮扶工作量
        // 指导青年教师工作量
        // 承担或参与教学文件制定、修订工作量
        model.addAttribute("QTJXGZInfo", checkService.getQTJXGZInfo(users.getGh()));
        // 强行在controller 中计算，难受，数据库为什么不存啊
        //学生学业指导帮扶工作量  ,取出帮扶学生人数，再计算
        model.addAttribute("BfGzl", checkService.getQTJXGZInfo(users.getGh()).getBfxsrs() * 10);
        // 指导青年教师工作量  ，取出指导青年教师人数，再计算
        model.addAttribute("ZdqnjsGzl", checkService.getQTJXGZInfo(users.getGh()).getZdqnjsrs() * 10);
        // 承担或参与教学文件制定、修订工作量， 取出是否写了人才培养方案，取出课程大纲数，取出实验大纲数，再计算
        model.addAttribute("WenjianGzl", checkService.getQTJXGZInfo(users.getGh()).getXdrcpyfa() * 20
                + checkService.getQTJXGZInfo(users.getGh()).getKcdgms() * 10
                + checkService.getQTJXGZInfo(users.getGh()).getSydgms() * 10);
        //研究生教学
        // 1 课堂教学工作量 graduateclass
        /*获取研究生的课堂类型，存入model*/
        model.addAttribute("yjskclx", yjsktjxService.getKclx());
        /*获取研究生的课堂信息，存入model*/
        model.addAttribute("yjsktjx", yjsktjxService.getYjsktjxInfo(users.getGh()));
        /*获取研究生课堂教学的总工作量*/
        model.addAttribute("ktjxgzlSum", yjsktjxService.getYjsjxgzlSum(users.getGh()));

        // 2 实践教学工作量 graduatepractice
        /*获取实践信息*/
        model.addAttribute("YJSSJJXInfo", checkService.getYJSSJJXInfo(users.getGh()));
        // 王行的
        Yjssjjx jbxx = yjssjjxService.getYjssjjxJbxx(users.getGh());
        if (jbxx != null) {
            /*获取指导学生次数工作量（显示）*/
            model.addAttribute("zdxshdcsGzl", GetPracticeWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(users.getGh()).getZdxshdcs()));
            /*获取日常工作量*/
            model.addAttribute("ZtGzl", jbxx.getGzl() - jbxx.getRcgzl() - GetPracticeWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(users.getGh()).getZdxshdcs()));
        }
        // 3 教学基本建设与学科建设工作 graduateconstruction
        if (jbjsyxkjsService.getWorkLoad(users.getGh()) == null) {
            model.addAttribute("sumOfWorkload", 0);
            model.addAttribute("sfzxpyfa", 0);
            model.addAttribute("kddgms", 0);
            model.addAttribute("sydgms", 0);
        } else {
            model.addAttribute("sumOfWorkload", jbjsyxkjsService.getWorkLoad(users.getGh()));
            model.addAttribute("JBJSYXKJSInfo", jbjsyxkjsService.getJBJSYXKJSInfo(users.getGh()));
        }
        /* 4 教学研究项目         graduateprogram */
        // 学科与研究生教育项目
        // 研究生横向项目项目
        model.addAttribute("yjsjyxms", yjsjyxmService.getYjsjyxm());
        model.addAttribute("yjshxxms", yjsjyxmService.getYjshxxm());
        model.addAttribute("jyxmGzl", yjsjyxmService.getYjsjyxmGzlSum(users.getGh()));
        model.addAttribute("hxxmGzl", yjsjyxmService.getYjshxxmGzlSum(users.getGh()));
        /* 5 指导研究生竞赛获奖 masterKnow */
        //****************************************************************************丑死了
        ZDSSLW zDSSLW = zDSSLWService.findZDSSLWByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        List<ZdxsjsVo> list = zDXSJSService.getStudentCompetitionList2(users.getGh(), DateUtils.getCurrentYear());
        for (int i = 0; i < list.size(); i++) {
            int jbbm = list.get(i).getJsjbbm();
            if (jbbm == 1) {
                list.get(i).setJsjbmc("省级");
            } else if (jbbm == 2) {
                list.get(i).setJsjbmc("校级重点");
            } else if (jbbm == 3) {
                list.get(i).setJsjbmc("一般项目");
            }
            int lbbm = list.get(i).getJslbbm();
            if (lbbm == 1) {
                list.get(i).setJslbmc("A类师范生教学技能竞赛");
            } else if (lbbm == 2) {
                list.get(i).setJslbmc("B类师范生教学技能竞赛");
            } else if (lbbm == 3) {
                list.get(i).setJslbmc("A类其他竞赛");
            } else if (lbbm == 4) {
                list.get(i).setJslbmc("B类其他竞赛");
            }
        }
        model.addAttribute("allStudentCompetitionList2", list);
        model.addAttribute("zDSSLW", zDSSLW);
        //****************************************************************************
        //TODO 后续自己写指导研究生竞赛
        // model.addAttribute("");
        // 教师指导学生学士学位论文获奖
        model.addAttribute("ZDXSLWInfo", checkService.getZDXSLWInfo(users.getGh()));
        // 6 其它教学工作量      masterOther
        model.addAttribute("YJSQTJXInfo", checkService.getYJSQTJXInfo(users.getGh()));
        return "officedetails";
    }
}
