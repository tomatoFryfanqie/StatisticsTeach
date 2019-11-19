package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.service.BksktjxService;
import org.jplus.service.TjztService;
import org.jplus.utils.GetYear;
import org.jplus.utils.GetClassWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.controller
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */

@Controller
public class ClassroomTeachController {
    private String classError = null;

    @Autowired
    private BksktjxService bksktjxService;
    @Autowired
    private TjztService tjztService;

    @NeedLogin
    @RequestMapping("/classroomteaching")
    public String getClassTechInfo(Model model, Users users) {
        /*获取年份。存入model*/
        model.addAttribute("year", GetYear.getYears());
        /*获取课堂类型，存入model*/
        model.addAttribute("ktlx", bksktjxService.getKtlxbm());
        /*获取本科生课堂教学信息，存入model*/
        model.addAttribute("bksktjx", bksktjxService.getBksktjxInfo(users.getGh()));
        /*获取课堂教学的总工作量*/
        model.addAttribute("ktjxgzlSum", bksktjxService.getBkjxgzlSum(users.getGh()));
        /*获取校验错误信息*/
        model.addAttribute("ClassError",classError);
        return "classroomteaching";
    }

    @NeedLogin
    @PostMapping("/addClassInfo")
    public String addClassInfo(@ModelAttribute(value = "bksktjxAccpet") @Validated BksktjxAccpet bksktjxAccpet,BindingResult bindingResult, Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行添加操作*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            if(bindingResult.hasErrors()){
                /*获得第一个校验错误*/
                classError = bindingResult.getFieldError().getDefaultMessage();
                if(classError.contains("NumberFormatException")){
                    classError = "请输入正确的信息";
                }
            }else {
                /*获取工号*/
                bksktjxAccpet.setGh(users.getGh());
                /*获取教学工作量*/
                bksktjxAccpet.setJxgzl(GetClassWork.getClassWork(bksktjxAccpet.getJhxs(), bksktjxAccpet.getSfsy(), bksktjxService.getKtlxbmBybm(bksktjxAccpet.getKtlxbm()), bksktjxAccpet.getSkrs()));
                /*存入年份*/
                bksktjxAccpet.setNd(GetYear.getYears());
                /*添加课堂信息*/
                bksktjxService.addClassInfo(bksktjxAccpet);
                /*将错误信息清空*/
                classError = null;
            }
        }
        return "redirect:classroomteaching";
    }

    @NeedLogin
    @RequestMapping(value = "/deleteClassInfo", method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "id") Integer id, Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行删除操作*/
        /*删除课堂信息*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            bksktjxService.deleteClassInfoBybksktjxId(id);
        }
        return "redirect:classroomteaching";
    }
}
