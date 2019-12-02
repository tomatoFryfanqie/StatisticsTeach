package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.yjsktjx.YjsktjxAccpet;
import org.jplus.service.TjztService;
import org.jplus.service.YjsktjxService;
import org.jplus.utils.GetWorkLoad;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.controller
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
@Controller
public class GraduateClassController {
    private String GClassError = null;

    @Autowired
    private YjsktjxService yjsktjxService;

    @Autowired
    private TjztService tjztService;

    @RequestMapping("/graduateclass")
    @NeedLogin
    public String getGraduateInfo(Model model, Users users){
        /*获取年份。存入model*/
        model.addAttribute("year", GetYear.getYears());
        /*获取研究生的课堂类型，存入model*/
        model.addAttribute("yjskclx", yjsktjxService.getKclx());
        /*获取研究生的课堂信息，存入model*/
        model.addAttribute("yjsktjx", yjsktjxService.getYjsktjxInfo(users.getGh()));
        /*获取研究生课堂教学的总工作量*/
        model.addAttribute("ktjxgzlSum", yjsktjxService.getYjsjxgzlSum(users.getGh()));
        /*获取验证错误*/
        model.addAttribute("GClassError", GClassError);
        return "graduateclass";
    }

    @PostMapping("/addYjsClassInfo")
    @NeedLogin
    public String addYjsClssInfo(@Validated @ModelAttribute(value = "yjsktjxAccpet")YjsktjxAccpet yjsktjxAccpet, BindingResult bindingResult, Users users){
        if(tjztService.getTjzt(users.getGh()).getTjzt()==0){
            if(bindingResult.hasErrors()){
                /*获得校验信息*/
                GClassError = bindingResult.getFieldError().getDefaultMessage();
                if(GClassError.contains("NumberFormatException")){
                    GClassError = "请输入正确的信息";
                }
            }else {
                /*获取工号*/
                yjsktjxAccpet.setGh(users.getGh());
                /*获取教学工作量*/
                yjsktjxAccpet.setGzl(GetWorkLoad.getYjsClassWorkLoad(yjsktjxAccpet.getJhxs(),yjsktjxService.getKclxrsBybm(yjsktjxAccpet.getKclx()), yjsktjxAccpet.getSkrs()));
                /*存入年份*/
                yjsktjxAccpet.setNd(GetYear.getYears());
                /*添加课堂信息*/
                yjsktjxService.addYjsClassInfo(yjsktjxAccpet);
                GClassError = null;
            }
        }
        return "redirect:graduateclass";
    }

    @NeedLogin
    @RequestMapping(value = "/deleteYjsClassInfo", method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "id") Integer id, Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行删除操作*/
        /*删除课堂信息*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            yjsktjxService.deleteClassInfoBybksktjxId(id);
        }
        return "redirect:graduateclass";
    }
}
