package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.zlgc.ZlgcAccept;
import org.jplus.service.TjztService;
import org.jplus.service.ZlgcService;
import org.jplus.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class QualityEngineerController {
    @Autowired
    ZlgcService zlgcService;
    @Autowired
    private TjztService tjztService;

    @NeedLogin
    @RequestMapping("/qualityengineering")
    public String getQualityEngineeringInfo(Model model, Users users) {
        //获取质量工程的工作总量
        model.addAttribute("sumOfWorkload",zlgcService.calculateSumOfWorkLoad(users.getGh()));
        //获取年份
        model.addAttribute("year", GetYear.getYears());
        // 质量工程的所有信息
        model.addAttribute("zlgc", zlgcService.getZlgcInfo(users.getGh()));
        model.addAttribute("hidden",tjztService.getTjzt(users.getGh()).getTjzt());
        return "qualityengineering";
    }

    @NeedLogin
    @PostMapping("/addZlgc")
    public String addZlgcInfo(@ModelAttribute(value = "zlgcAccept") ZlgcAccept zlgcAccept,Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行添加操作*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            zlgcAccept.setNd(zlgcAccept.getNd());
            zlgcAccept.setGh(UserContext.getUser().getGh());
            zlgcAccept.setGzl(GetWorkLoad.getQualityEngineerWorkLoad(zlgcAccept.getXmlxbm(), zlgcAccept.getJb(), zlgcAccept.getXmpm(), zlgcAccept.getZrs()));
            zlgcService.addZlgcInfo(zlgcAccept);
        }
        return "redirect:/qualityengineering";
    }

    @NeedLogin
    @RequestMapping("/deleteZlgcInfo")
    public String deleteZlgcInfo(@ModelAttribute(value = "id") Integer id,Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行添加操作*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            zlgcService.deleteZlgcInfo(id);
        }
        return "redirect:/qualityengineering";
    }

    @NeedLogin
    @RequestMapping("/updateZlgcInfo")
    public String updateZlgcInfo(@ModelAttribute("zlgcAccept") ZlgcAccept zlgcAccept) {
        zlgcAccept.setGzl(GetWorkLoad.getQualityEngineerWorkLoad(zlgcAccept.getXmlxbm(), zlgcAccept.getJb(), zlgcAccept.getXmpm(), zlgcAccept.getZrs()));
        zlgcService.updateZlgcInfo(zlgcAccept);
        return "redirect:/qualityengineering";
    }

}
