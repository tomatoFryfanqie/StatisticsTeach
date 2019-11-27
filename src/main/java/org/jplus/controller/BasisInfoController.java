package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Tjzt.Tjzt;
import org.jplus.pojo.Users;
import org.jplus.pojo.basisInfo.JbxxAccpet;
import org.jplus.service.BksktjxService;
import org.jplus.service.JbxxService;
import org.jplus.service.TjztService;
import org.jplus.utils.GetRatedWorkload;
import org.jplus.utils.GetRatedTeachTime;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.controller
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
@Controller
public class BasisInfoController {

    @Autowired
    private JbxxService jbxxService;
    @Autowired
    private TjztService tjztService;
    @Autowired
    private BksktjxService bksktjxService;

    @NeedLogin
    @RequestMapping("/basicinformation")
    public String getInfo(Model model, Users users){
        /*获取院系信息,做下拉列表*/
        model.addAttribute("yxType", jbxxService.getYxbmInfo());
        /*获取职务信息,做下拉列表*/
        model.addAttribute("zwType",jbxxService.getZwbmInfo());
        /*获取职称信息,做下拉列表*/
        model.addAttribute("zcType",jbxxService.getZcbmInfo());
        /*获取岗位信息,做下拉列表*/
        model.addAttribute("gwlxType", jbxxService.getGwlxbmInfo());
        /*获取年度*/
        model.addAttribute("Nd", GetYear.getYears());
        /*获取本科生最低授课工作量*/
        model.addAttribute("bkszdgzl",bksktjxService.getBkjxgzlSum(users.getGh()));
        /*获取用户信息*/
        model.addAttribute("user", users);
        /*获取基本信息存到model中*/
        model.addAttribute("basisInfo", jbxxService.getJbxxInfo(users.getGh()));
        /*在首次登录到首页面时候，初始化该工号下的提交状态*/
        if(tjztService.getTjzt(users.getGh())==null){
            Tjzt tjzt = new Tjzt();
            tjzt.setGh(users.getGh());
            tjzt.setTjzt(0);
            tjzt.setShzt(0);
            tjztService.addTjzt(tjzt.getGh(),tjzt.getTjzt(),tjzt.getShzt());
        }
        return "basicinformation";
    }

    @NeedLogin
    @PostMapping("/updateBasisInfo")
    public String updateJbxxInfo(@ModelAttribute(value = "jbxxAccpet") JbxxAccpet jbxxAccpet,Users users){

        /*如果提交状态表中的提交状态处于0:未提交状态,则可以进行更新操作*/
        if(tjztService.getTjzt(users.getGh()).getTjzt()==0){
            /*判断该用户的的jbxxInfo是否为空*/
            if(jbxxService.getJbxxInfo(users.getGh())==null){
                jbxxService.addJbxx(users.getGh());
            }
            jbxxAccpet.setNd(GetYear.getYears());
            /*获取额定工作量*/
            jbxxAccpet.setEdgzl(GetRatedWorkload.getRatedWorkload(jbxxAccpet.getZcbm(),jbxxAccpet.getGwlxbm(),jbxxAccpet.getSfxrz()));
            /*获取本科生最低授课工作量*/
            jbxxAccpet.setBkszdsk(GetRatedTeachTime.getTeachTime(jbxxAccpet.getZcbm(), jbxxAccpet.getGwlxbm()));
            /*更新部分基本信息*/
            System.out.println(jbxxAccpet);
            jbxxService.updateBasisInfo(jbxxAccpet);
        }
        return "redirect:basicinformation";
    }
}
