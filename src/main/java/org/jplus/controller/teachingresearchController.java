package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.teachingresearchInfo.*;
import org.jplus.service.JxcgServiceImpl;
import org.jplus.service.TjztService;
import org.jplus.utils.GetWorkCount;
import org.jplus.utils.GetYear;
import org.jplus.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotEmpty;


/**
 * @description: 教学研究控制层
 * @author:zmj
 * @date 2019/10/3116:35
 */
@Controller
public class teachingresearchController {

    @Autowired
    JxcgServiceImpl jxcgService;

    @Autowired
    TjztService tjztService;

    //数据显示
    @NeedLogin
    @RequestMapping("/teachingresearch")
    public String getInfo(Model model, Users users) {
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
        model.addAttribute("gh", users.getGh());

        model.addAttribute("jxcgGzl",jxcgService.getJxcgGzlSun(users.getGh()));
        model.addAttribute("zxxmGzl",jxcgService.getZxxmGzlSun(users.getGh()));
        model.addAttribute("hxxmGzl",jxcgService.getHxxmGzlSun(users.getGh()));
        model.addAttribute("jcGzl",jxcgService.getJcGzlSun(users.getGh()));
        model.addAttribute("jxggGzl",jxcgService.getJxggGzlSun(users.getGh()));
        return "teachingresearch";
    }

    //删除教学成果某一列
    @NeedLogin
    @RequestMapping("/delJxcg")
    public String delJxcg(Integer id,Users user) {
    //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            jxcgService.deleteJxcg(id);
        }
            return "redirect:/teachingresearch";
    }

    //添加教学成果某一列
    @NeedLogin
    @PostMapping("/addJxcg")

    public String addJxcg(@ModelAttribute(value = "jxcg") Jxcg jxcg,Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            jxcg.setGh(user.getGh());
            //获取工作量
            jxcg.setGzl(GetWorkCount.GetWorkCount(jxcg.getZrs(), jxcg.getXmpm(),
                    jxcgService.getGdgzl(jxcg.getCgdjbm())));
            //存入年份
            jxcg.setNd(GetYear.getYears());
            //添加信息
            jxcgService.addJxcg(jxcg);
        }
            return "redirect:/teachingresearch";
    }

    //删除纵向教研项目的某一列
    @NeedLogin
    @RequestMapping("/delZxxm")
    public String delZxxm(Integer id,Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            jxcgService.deleteZxxm(id);
        }
        return "redirect:/teachingresearch";

    }

    //添加纵向教研项目的某一列
    @NeedLogin
    @PostMapping("/addZxxm")
    public String addZxxm(@ModelAttribute(value = "zxxm") Zxxm zxxm, Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            zxxm.setGh(user.getGh());
            //获取工作量
            zxxm.setGzl(GetWorkCount.GetWorkCount(zxxm.getZrs(), zxxm.getXmpm(),
                    jxcgService.getZxxmgzl(zxxm.getXmdjbm())));
            //存入年份
            zxxm.setNd(GetYear.getYears());
            //添加信息
            jxcgService.addZxxm(zxxm);
        }
        return "redirect:/teachingresearch";
    }


    //删除纵向教研项目的某一列
    @NeedLogin
    @RequestMapping("/delHxxm")
    public String delHxxm(Integer id,Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            jxcgService.deleteHxxm(id);
        }
            return "redirect:/teachingresearch";
    }

    //添加纵向教研项目的某一列
    @NeedLogin
    @PostMapping("/addHxxm")
    public String addHxxm(@ModelAttribute(value = "hxxm") Hxxm hxxm, Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            hxxm.setGh(user.getGh());
            //获取工作量
            hxxm.setGzl((GetWorkCount.GetHxWorkCount(hxxm.getDzjf()) > 200) ? 200 :
                    GetWorkCount.GetHxWorkCount(hxxm.getDzjf()));
            //存入年份
            hxxm.setNd(GetYear.getYears());
            //添加信息
            jxcgService.addHxxm(hxxm);
        }
        return "redirect:/teachingresearch";
    }

    //删除教材某一列
    @NeedLogin
    @RequestMapping("/delJc")
    public String delJc(Integer id,Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            jxcgService.deleteJc(id);
        }
        return "redirect:/teachingresearch";
    }

    //添加教材的某一列
    @NeedLogin
    @PostMapping("/addJc")
    public String addJc(@ModelAttribute(value = "jc")Jc jc, Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            jc.setGh(user.getGh());
            //获取工作量
            jc.setGzl(GetWorkCount.GetWorkCount(jc.getZrs(), jc.getXmpm(),
                    jxcgService.getZxxmgzl(jc.getJcjbbm())));
            //存入年份
            jc.setNd(GetYear.getYears());
            //添加信息
            jxcgService.addJc(jc);
        }
        return "redirect:/teachingresearch";
    }

    //删除教学改革某一列
    @NeedLogin
    @RequestMapping("/delJxgg")
    public String delJxgg(Integer id,Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            jxcgService.deleteJxgg(id);
        }
        return "redirect:/teachingresearch";
    }

    //添加教学改革的某一列
    @NeedLogin
    @PostMapping("/addJxgg")
    public String addJc(@ModelAttribute(value = "jxgg")Jxgg jxgg, Users user) {
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            jxgg.setGh(user.getGh());
            //获取工作量
            jxgg.setGzl(GetWorkCount.GetWorkCount(jxgg.getZrs(), jxgg.getXmpm(),
                    jxcgService.getZxxmgzl(jxgg.getLxjbbm())));
            //存入年份
            jxgg.setNd(GetYear.getYears());
            //添加信息
            jxcgService.addJxgg(jxgg);
        }
        return "redirect:/teachingresearch";
    }
}

