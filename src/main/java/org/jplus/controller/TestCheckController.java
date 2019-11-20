package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.JSJS;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
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

/**
 * @program: StatisticsTeach
 * @description: 测试审核界面
 * @author: MH
 * @create: 2019-11-12 21:57
 **/

@Controller
public class TestCheckController {
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
    private TjztService tjztService;

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
        model.addAttribute("name",users.getUname());
        /*获取基本信息存到model中*/
        model.addAttribute("department",checkService.getYxmc(users.getYxbm()));

        checkService.getYxmc(users.getYxbm());
     //本科生教学
        // 1 用户的课堂教学工作量   classroomteaching
        model.addAttribute("bksktjx", bksktjxService.getBksktjxInfo(users.getGh()));
        // 2 实践教学工作量         practiceteh
        Optional.ofNullable(bkssjjxService.selectSxlx()).ifPresent(sxlx-> model.addAttribute("sxlxlist",sxlx));
        Optional.ofNullable(bkssjjxService.selectZylxbm()).ifPresent(zybm-> model.addAttribute("zylxlist",zybm));
        Optional.ofNullable(bkssjjxService.selectBkssjjx(users.getGh())).ifPresent(sjjx->model.addAttribute
                ("bkssjjx",getSjjxWork(sjjx)));
        // 3 质量工程工作量        qualityengineering
        model.addAttribute("zlgc", zlgcService.getZlgcInfo());
        //获取质量工程的工作总量
        model.addAttribute("zlgcSumOfWorkload",zlgcService.calculateSumOfWorkLoad(users.getGh()));
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

        model.addAttribute("jxcgGzl",jxcgService.getJxcgGzlSun(users.getGh()));
        model.addAttribute("zxxmGzl",jxcgService.getZxxmGzlSun(users.getGh()));
        model.addAttribute("hxxmGzl",jxcgService.getHxxmGzlSun(users.getGh()));
        model.addAttribute("jcGzl",jxcgService.getJcGzlSun(users.getGh()));
        model.addAttribute("jxggGzl",jxcgService.getJxggGzlSun(users.getGh()));

        /* 5 教学知识竞赛              know*/
        // 指导学生竞赛工作量
        // 教师教学能力竞赛获奖工作量
        // 教师指导学生学士学位论文获奖工作量
        List<JsjsVo> result = jSJSService.getTeacherCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        List<ZdxsjsVo> list = zDXSJSService.getStudentCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        ZDXSLW zDXSLW = zDXSJSService.findZDXSLWByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        model.addAttribute("allStudentCompetitionList", list);
        model.addAttribute("allTeacherCompetitionList", result);
        model.addAttribute("zDXSLW", zDXSLW);
        /* 6 其它教育教学活动       TODO  other*/
        // 教学督导工作量
        // 学生学业指导帮扶工作量
        // 指导青年教师工作量
        // 承担或参与教学文件制定、修订工作量


     //研究生教学
        // 1 课堂教学工作量 graduateclass
        /*获取研究生的课堂类型，存入model*/
        model.addAttribute("yjskclx", yjsktjxService.getKclx());
        /*获取研究生的课堂信息，存入model*/
        model.addAttribute("yjsktjx", yjsktjxService.getYjsktjxInfo(users.getGh()));
        /*获取研究生课堂教学的总工作量*/
        model.addAttribute("ktjxgzlSum", yjsktjxService.getYjsjxgzlSum(users.getGh()));

        // 2 实践教学工作量 graduatepractice
        /*获取实践类型*/
        model.addAttribute("yjssjlx", yjssjjxService.getSjlx());
        /*获取研究生实践类型的基本信息*/
        Yjssjjx jbxx = yjssjjxService.getYjssjjxJbxx(users.getGh());
        if(jbxx!=null) {
            /*获取指导学生次数工作量（显示）*/
            model.addAttribute("zdxshdcsGzl", GetPracticeWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(users.getGh()).getZdxshdcs()));
            /*获取自行增加的工作量*/
            model.addAttribute("ZtGzl", jbxx.getGzl() - jbxx.getRcgzl() - GetPracticeWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(users.getGh()).getZdxshdcs()));
        }
        model.addAttribute("yjssjjxJbxx", jbxx);
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
        model.addAttribute("yjsjyxms",yjsjyxmService.getYjsjyxm());
        model.addAttribute("yjshxxms",yjsjyxmService.getYjshxxm());
        model.addAttribute("jyxmGzl",yjsjyxmService.getYjsjyxmGzlSum(users.getGh()));
        model.addAttribute("hxxmGzl",yjsjyxmService.getYjshxxmGzlSum(users.getGh()));
        /* 5 指导研究生竞赛获奖 masterKnow */
        // 指导研究生竞赛
        // 教师指导学生学士学位论文获奖
        List<ZdxsjsVo> list2 = zDXSJSService.getStudentCompetitionList(users.getGh(),GetYear.getYears());
        model.addAttribute("allStudentCompetitionList", list2);
        // 6 其它教学工作量    TODO  masterOther
        return "officedetails";
    }

}
