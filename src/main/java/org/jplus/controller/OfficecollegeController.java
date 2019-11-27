package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.service.OfficecollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:审核本院和其他院工作量1控制层
 * @author:zmj
 * @date 2019/11/1615:05
 */
@Controller
public class OfficecollegeController {

    private Integer yxbmF = null;

   @Autowired
   OfficecollegeService officecollegeService;

   //审核本院工作量
    @NeedLogin
    @RequestMapping("/officecollege")
    public String officecollege(Users user, Model model){
        model.addAttribute("yxbm",officecollegeService.getYxbm(user.getGh()));
        model.addAttribute("Checkgzls",officecollegeService.getCheckgzlInfByGh(user.getGh()));
        return "officecollege";
    }

    //审核各院工作量本院信息显示
    @NeedLogin
    @RequestMapping("/departmentalaudit")
    public String departmentalaudit(Users user,Model model){
        //用于回显数据
        model.addAttribute("theyxbm",officecollegeService.getYxbm(user.getGh()));
        model.addAttribute("yxbms",officecollegeService.getAllYxbm());
        model.addAttribute("Checkgzls",officecollegeService.getCheckgzlInfByGh(user.getGh()));
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
