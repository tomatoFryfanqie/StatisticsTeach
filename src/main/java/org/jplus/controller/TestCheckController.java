package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Tjzt.Tjb;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.jplus.pojo.queryVo.JsjsVo;
import org.jplus.pojo.queryVo.ZdxsjsVo;
import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.service.*;
import org.jplus.utils.DateUtils;
import org.jplus.utils.GetWorkLoad;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.jplus.utils.GetWorkLoad.getSjjxWork;

/*
 * @author MH
 * @date 2019/11/23 23:30
 *  审核页面控制类，版本 1.0
 */
@Controller
public class TestCheckController {
    @Autowired
    private TjztService tjztService;
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
    @Autowired
    private TjbService tjbService;

    @NeedLogin
    @RequestMapping("/testCheck")
    public String getofficedetails(Model model) {
        return "departmentalaudit";
    }

    @NeedLogin
    @GetMapping("/officedetails")
    public String getQualityEngineeringInfo(@ModelAttribute(value = "gh") String gh,
                                            @ModelAttribute(value = "userName") String userName,
                                            @ModelAttribute(value = "yxmc") String yxmc,
                                            Model model, Users users) {
        // 将用户的信息取出( 工号， 姓名， 院系编码)
        model.addAttribute("gh", gh);
        model.addAttribute("name", userName);
        /*获取基本信息存到model中*/
        model.addAttribute("department", yxmc);
// *************************************************************************************
        Tjb tjb = tjbService.getTjbByGh(gh);
        if (tjb != null){
            //                <!-- 本科生课堂工作量-->				bksktgzl
            model.addAttribute("bksktgzl",tjb.getBksktgzl());
//                <!-- 本科生实践工作量-->				bkssjgzl
            model.addAttribute("bkssjgzl",tjb.getBkssjgzl());
//                <!-- 质量工程工作量 -->					zlgcgzl
            model.addAttribute("zlgcgzl",tjb.getZlgcgzl());
//                <!-- 教学成果工作量 -->					jxcggzl
            model.addAttribute("jxcggzl",tjb.getJxcggzl());
//                <!-- 本科生纵向项目工作量-->			bkszxxmgzl
            model.addAttribute("bkszxxmgzl",tjb.getBkszxxmgzl());
//                <!-- 本科生横向项目工作量-->			bkshxxmgzl
            model.addAttribute("bkshxxmgzl",tjb.getBkshxxmgzl());
//                <!-- 教材工作量-->						jcgzl
            model.addAttribute("jcgzl",tjb.getJcgzl());
//                <!-- 教学改革工作量-->					jxgggzl
            model.addAttribute("jxgggzl",tjb.getJxgggzl());
//                <!-- 本科生竞赛工作量-->				bksjsgzl
            model.addAttribute("bksjsgzl",tjb.getBksjsgzl());
//                <!-- 教师竞赛工作量-->					jsjsgzl
            model.addAttribute("jsjsgzl",tjb.getJsjsgzl());
//                <!-- 本科生论文工作量-->				bkslwgzl
            model.addAttribute("bkslwgzl",tjb.getBkslwgzl());
//                <!-- 本科生其它工作量-->				bksqtgzl
            model.addAttribute("bksqtgzl",tjb.getBksqtgzl());
//                <!-- 本科生总工作量-->					bkszgzl
            model.addAttribute("bkszgzl",tjb.getYjszgzl());
// *************************************************************************************
//                <!-- 研究生课堂教学工作量-->				yjsktjxgzl
            model.addAttribute("yjsktjxgzl",tjb.getYjsktjxgzl());

//                <!-- 研究生实践教学工作量-->				jsjsjjxgzl
            model.addAttribute("jsjsjjxgzl",tjb.getJsjsjjxgzl());
//                <!-- 学科建设工作量-->						xkjsgzl
            model.addAttribute("xkjsgzl",tjb.getXkjsgzl());
//                <!-- 研究生教研项目工作量-->				yjsjyxmgzl
            model.addAttribute("yjsjyxmgzl",tjb.getYjsjyxmgzl());
//                <!-- 研究生横向项目工作量-->				yjshxxmgzl
            model.addAttribute("yjshxxmgzl",tjb.getYjshxxmgzl());
//                <!-- 研究生论文工作量-->					yjslwgzl
            model.addAttribute("yjslwgzl",tjb.getYjslwgzl());
//                <!-- 研究生竞赛工作量-->					yjsjsgzl
            model.addAttribute("yjsjsgzl",tjb.getJsjsgzl());
//                <!-- 研究生其它工作量-->					yjsqtgzl
            model.addAttribute("yjsqtgzl",tjb.getYjsqtgzl());
//                <!-- 研究生总工作量-->						yjszgzl
            model.addAttribute("yjszgzl",tjb.getYjszgzl());
// *************************************************************************************
        }else {
            model.addAttribute("bksktgzl",0.0);
//                <!-- 本科生实践工作量-->				bkssjgzl
            model.addAttribute("bkssjgzl",0.0);
//                <!-- 质量工程工作量 -->					zlgcgzl
            model.addAttribute("zlgcgzl",0.0);
//                <!-- 教学成果工作量 -->					jxcggzl
            model.addAttribute("jxcggzl",0.0);
//                <!-- 本科生纵向项目工作量-->			bkszxxmgzl
            model.addAttribute("bkszxxmgzl",0.0);
//                <!-- 本科生横向项目工作量-->			bkshxxmgzl
            model.addAttribute("bkshxxmgzl",0.0);
//                <!-- 教材工作量-->						jcgzl
            model.addAttribute("jcgzl",0.0);
//                <!-- 教学改革工作量-->					jxgggzl
            model.addAttribute("jxgggzl",0.0);
//                <!-- 本科生竞赛工作量-->				bksjsgzl
            model.addAttribute("bksjsgzl",0.0);
//                <!-- 教师竞赛工作量-->					jsjsgzl
            model.addAttribute("jsjsgzl",0.0);
//                <!-- 本科生论文工作量-->				bkslwgzl
            model.addAttribute("bkslwgzl",0.0);
//                <!-- 本科生其它工作量-->				bksqtgzl
            model.addAttribute("bksqtgzl",0.0);
//                <!-- 本科生总工作量-->					bkszgzl
            model.addAttribute("bkszgzl",0.0);
// *************************************************************************************
//                <!-- 研究生课堂教学工作量-->				yjsktjxgzl
            model.addAttribute("yjsktjxgzl",0.0);

//                <!-- 研究生实践教学工作量-->				jsjsjjxgzl
            model.addAttribute("jsjsjjxgzl",0.0);
//                <!-- 学科建设工作量-->						xkjsgzl
            model.addAttribute("xkjsgzl",0.0);
//                <!-- 研究生教研项目工作量-->				yjsjyxmgzl
            model.addAttribute("yjsjyxmgzl",0.0);
//                <!-- 研究生横向项目工作量-->				yjshxxmgzl
            model.addAttribute("yjshxxmgzl",0.0);
//                <!-- 研究生论文工作量-->					yjslwgzl
            model.addAttribute("yjslwgzl",0.0);
//                <!-- 研究生竞赛工作量-->					yjsjsgzl
            model.addAttribute("yjsjsgzl",0.0);
//                <!-- 研究生其它工作量-->					yjsqtgzl
            model.addAttribute("yjsqtgzl",0.0);
//                <!-- 研究生总工作量-->						yjszgzl
            model.addAttribute("yjszgzl",0.0);
        }



// **************************************具体信息***********************************************
        //本科生教学
        // 1 用户的课堂教学信息   classroomteaching
        model.addAttribute("bksktjx", bksktjxService.getBksktjxInfo(gh));

        // 2 实践教学工作量         practiceteh
        Optional.ofNullable(bkssjjxService.selectBkssjjx(gh)).ifPresent(sjjx -> model.addAttribute
                ("bkssjjx", getSjjxWork(sjjx)));
        model.addAttribute("bkssjjxInfo",null);
        model.addAttribute("bkssjjxInfo", checkService.getBKSSJJXInfo(gh));
        // 3 质量工程工作量        qualityengineering
        model.addAttribute("zlgc", zlgcService.getZlgcInfo(gh));

        /*  4教学研究              teachingresearch */
        // 教学成果工作量
        //  纵向教研项目工作量
        //  横向教研项目工作量
        //  编写规划教材、教材获奖工作量
        //  教学改革工作量
        model.addAttribute("Jxcgs", jxcgService.getJxcgInfo(gh));
        model.addAttribute("Jxcgdjs", jxcgService.getJxcgdjInfo());

        model.addAttribute("Zxxms", jxcgService.getZxxm(gh));
        model.addAttribute("Zxxmdjs", jxcgService.getZxxmdjInfo());

        model.addAttribute("Hxxms", jxcgService.getHxxm(gh));

        model.addAttribute("Jcs", jxcgService.getJc(gh));
        model.addAttribute("Jcjbs", jxcgService.getJcjbInfo());

        model.addAttribute("Jxggs", jxcgService.getJxgg(gh));
        model.addAttribute("Lxjbs", jxcgService.getLxjbInfo());
        model.addAttribute("year", GetYear.getYears());
//        model.addAttribute("gh", gh);

        /* 5 教学知识竞赛              know*/
        // TODO 后续自己重写，都不用wb的  学生竞赛和教师竞赛
        List<JsjsVo> result = jSJSService.getTeacherCompetitionList(gh, DateUtils.getCurrentYear());
        List<ZdxsjsVo> list1 = zDXSJSService.getStudentCompetitionList(gh, DateUtils.getCurrentYear());
        ZDXSLW zDXSLW = zDXSJSService.findZDXSLWByGhAndYear(gh, DateUtils.getCurrentYear());
        model.addAttribute("allStudentCompetitionList", list1);
        model.addAttribute("allTeacherCompetitionList", result);
        model.addAttribute("zDXSLW", zDXSLW);
        // 教师指导学生学士学位论文获奖
        model.addAttribute("ZDSSLWInfo", checkService.getZDSSLWInfo(gh));

        /* 6 其它教育教学活动         other*/
        // 教学督导工作量 （可从数据库取）
        // 学生学业指导帮扶工作量
        // 指导青年教师工作量
        // 承担或参与教学文件制定、修订工作量

        model.addAttribute("QTJXGZInfo", checkService.getQTJXGZInfo(gh));
        // 强行在controller 中计算，难受，数据库为什么不存啊
        //学生学业指导帮扶工作量  ,取出帮扶学生人数，再计算
        if (checkService.getQTJXGZInfo(gh) != null) {
            model.addAttribute("BfGzl", checkService.getQTJXGZInfo(gh).getBfxsrs() * 10);
        } else {
            model.addAttribute("BfGzl", 0.0);
        }
        // 指导青年教师工作量  ，取出指导青年教师人数，再计算
        if (checkService.getQTJXGZInfo(gh) != null) {
            model.addAttribute("ZdqnjsGzl", checkService.getQTJXGZInfo(gh).getZdqnjsrs() * 10);
        } else {
            model.addAttribute("ZdqnjsGzl", 0.0);
        }
        // 承担或参与教学文件制定、修订工作量， 取出是否写了人才培养方案，取出课程大纲数，取出实验大纲数，再计算
        if (checkService.getQTJXGZInfo(gh) != null) {
            model.addAttribute("WenjianGzl", checkService.getQTJXGZInfo(gh).getXdrcpyfa() * 20
                    + checkService.getQTJXGZInfo(gh).getKcdgms() * 10
                    + checkService.getQTJXGZInfo(gh).getSydgms() * 10);
        } else {
            model.addAttribute("WenjianGzl", 0.0);
        }
        //        //研究生教学
        // 1 课堂教学工作量 graduateclass
        /*获取研究生的课堂类型，存入model*/
        model.addAttribute("yjskclx", yjsktjxService.getKclx());
        /*获取研究生的课堂信息，存入model*/
        model.addAttribute("yjsktjx", yjsktjxService.getYjsktjxInfo(gh));

        // 2 实践教学工作量 graduatepractice
        /*获取实践信息*/
        model.addAttribute("YJSSJJXInfo", checkService.getYJSSJJXInfo(gh));

        // 王行的
        Yjssjjx jbxx = yjssjjxService.getYjssjjxJbxx(gh);
        if (jbxx != null) {
            /*获取指导学生次数工作量（显示）*/
            model.addAttribute("zdxshdcsGzl", GetWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(gh).getZdxshdcs()));
            /*获取日常工作量*/
            model.addAttribute("ZtGzl", jbxx.getGzl() - jbxx.getRcgzl() - GetWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(gh).getZdxshdcs()));
        }

        // 3 教学基本建设与学科建设工作 graduateconstruction
        if (tjb != null){
            if (tjb.getXkjsgzl() == null) {
                model.addAttribute("xkjsgzl", 0);
                model.addAttribute("sfzxpyfa", 0);
                model.addAttribute("kddgms", 0);
                model.addAttribute("sydgms", 0);
            } else {
                model.addAttribute("xkjsgzl", tjb.getXkjsgzl());
                model.addAttribute("JBJSYXKJSInfo", jbjsyxkjsService.getJBJSYXKJSInfo(gh));
            }
        }else {
            model.addAttribute("xkjsgzl", 0);
            model.addAttribute("sfzxpyfa", 0);
            model.addAttribute("kddgms", 0);
            model.addAttribute("sydgms", 0);
        }

        /* 4 教学研究项目         graduateprogram */
        // 学科与研究生教育项目
        // 研究生横向项目项目
        model.addAttribute("yjsjyxms", yjsjyxmService.getYjsjyxm(gh));
        model.addAttribute("yjshxxms", yjsjyxmService.getYjshxxm(gh));


        /* 5 指导研究生竞赛获奖 masterKnow */
        //****************************************************************************丑死了
        ZDSSLW zDSSLW = zDSSLWService.findZDSSLWByGhAndYear(gh, DateUtils.getCurrentYear());
        List<ZdxsjsVo> list = zDXSJSService.getStudentCompetitionList2(gh, DateUtils.getCurrentYear());
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

        // 教师指导学生学士学位论文获奖
        model.addAttribute("ZDXSLWInfo", checkService.getZDXSLWInfo(gh));
        // 6 其它教学工作量      masterOther
        model.addAttribute("YJSQTJXInfo", checkService.getYJSQTJXInfo(gh));
// **************************************具体信息***********************************************
        return "officedetails";
    }

    @NeedLogin
    @GetMapping("/passCheck")
    public String passCheck(@ModelAttribute(value = "gh") String gh,Users users) {
        java.sql.Timestamp date = new java.sql.Timestamp(new Date().getTime());
        // 根据工号判断审核人的身份
        // 如果是院系负责人
        if (users.getActor() == 2){
            if (tjztService.getTjzt(gh).getTjzt() != 0) {
                // tjzt 将审核状态设置为审核1 ( 院系审核) ,姓名，审核时间写进去
                checkService.setShztByDepartments(gh,users.getUname(),date);
                // 将院系审核人的名字写到提交表tjb
                checkService.setShrgh(gh,users.getGh());
            }
        }
        // 如果是教务处负责人
        if (users.getActor() == 3){
            if (tjztService.getTjzt(gh).getTjzt() != 0) {
                // tjzt  将审核状态设置为审核2 ( 教务处审核)姓名，审核时间写进去
                checkService.setShztByOffice(gh,users.getUname(),date);
            }
        }
        if (users.getActor() == 2){
            return "redirect:/officecollege";
        }
        else {
            return "redirect:/departmentalaudit";
        }
    }


    @NeedLogin
    @GetMapping("/backCheck")
    public String backCheck(@ModelAttribute(value = "gh") String gh,Users users) {
        // 将审核状态设置为未审核 ,将提交状态设置为未提交
        checkService.clearTjztAndShzt(gh);

        // 返回上一个页面 officecollege
        if (users.getActor() == 2){
            return "redirect:/officecollege";
        }
        else {
            return "redirect:/departmentalaudit";
        }
    }

}
