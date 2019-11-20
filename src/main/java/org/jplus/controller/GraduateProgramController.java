package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.yjsjyxm.Yjshxxm;
import org.jplus.pojo.yjsjyxm.Yjsjyxm;
import org.jplus.service.TjztService;
import org.jplus.service.YjsjyxmService;
import org.jplus.utils.GetWorkCount;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 研究生教学研究项目控制层
 * @author:zmj
 * @date 2019/11/815:39
 */
@Controller
public class GraduateProgramController {

    @Autowired
    private YjsjyxmService yjsjyxmService;

    @Autowired
    TjztService tjztService;

//主要数据
    @NeedLogin
    @RequestMapping("/graduateprogram")
    public String graduateProgramInfo(Model model, Users user){
        model.addAttribute("year",GetYear.getYears());
        model.addAttribute("yjsjyxms",yjsjyxmService.getYjsjyxm());
        model.addAttribute("yjshxxms",yjsjyxmService.getYjshxxm());
        model.addAttribute("jyxmGzl",yjsjyxmService.getYjsjyxmGzlSum(user.getGh()));
        model.addAttribute("hxxmGzl",yjsjyxmService.getYjshxxmGzlSum(user.getGh()));
        return "/graduateprogram";
    }

//教研项目删除
    @RequestMapping("/delYjsjyxm")
    public String delYjsjyxm(Integer id,Users user){
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            yjsjyxmService.delYjsjyxm(id);
        }
        return "redirect:/graduateprogram";
    }

//教研项目新增
    @PostMapping("/addYjsjyxm")
    public String addYjsjyxm(Yjsjyxm yjsjyxm,Users user){
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            yjsjyxm.setGh(user.getGh());
            //获取年度
            yjsjyxm.setNd(GetYear.getYears());
            //获取工作量
            yjsjyxm.setGzl(GetWorkCount.GetWorkCount(yjsjyxm.getZrs(), yjsjyxm.getXmpm(),
                    yjsjyxm.getXmdjbm() == 1 ? 200 : 50));
            //添加项目的一列
            yjsjyxmService.addYjsjyxm(yjsjyxm);
        }
        return "redirect:/graduateprogram";
    }

//研究生横向项目删除
    @RequestMapping("/delYjshxxm")
    public String delYjshxxm(Integer id,Users user){
        //提交状态处于0，表示未提交可以操作数据
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            yjsjyxmService.delYjshxxm(id);
        }
        return "redirect:/graduateprogram";
    }

//研究生横向项目新增
    @PostMapping("/addYjshxxm")
    public String addYjshxxm(Yjshxxm yjshxxm, Users user){
        if (tjztService.getTjzt(user.getGh()).getTjzt() == 0) {
            //获取工号
            yjshxxm.setGh(user.getGh());
            //获取年度
            yjshxxm.setNd(GetYear.getYears());
            //获取工作量
            yjshxxm.setGzl(GetWorkCount.GetHxWorkCount(yjshxxm.getZrs(),yjshxxm.getXmpm(),
                    yjshxxm.getDzjf()));
            //添加项目的一列
            yjsjyxmService.addYjshxxm(yjshxxm);
        }
        return "redirect:/graduateprogram";
    }
}
