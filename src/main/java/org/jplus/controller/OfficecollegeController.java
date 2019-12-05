package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.service.OfficecollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OfficecollegeController {


   @Autowired
   OfficecollegeService officecollegeService;

   //审核本院工作量
    @NeedLogin
    @RequestMapping("/officecollege")
    public String officecollege(Users user, Model model){
        model.addAttribute("yxmc",officecollegeService.getYxmc(user.getGh()));
        model.addAttribute("Checkgzls",officecollegeService.getCheckgzlInfByGh(user.getGh()));
        return "officecollege";
    }

    //审核各院工作量本院信息显示
    @NeedLogin
    @RequestMapping("/departmentalaudit")
    public String departmentalaudit(Model model){
        model.addAttribute("yxbms",officecollegeService.getAllYxbm());
        return "departmentalaudit";
    }

    //审核各院工作量其他院信息选择显示
    @NeedLogin
    @RequestMapping("/departmentalaudit2")
    public String departmentalaudit2(Model model,Integer yxbm){
        //用于回显数据
        model.addAttribute("theyxbm",yxbm);
        model.addAttribute("yxbms",officecollegeService.getAllYxbm());
        model.addAttribute("Checkgzls",officecollegeService.getCheckgzlInfByYxbm(yxbm));
        return "departmentalaudit";
    }
}
