package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.service.BksktjxService;
import org.jplus.utils.GetYear;
import org.jplus.utils.GetClassWork;
import org.jplus.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private BksktjxService bksktjxService;

    @NeedLogin
    @RequestMapping("/classroomteaching")
    public String getClassTechInfo(Model model,Users users){
        /*获取年份。存入model*/
        model.addAttribute("year", GetYear.getYears());
        /*获取课堂类型，存入model*/
        model.addAttribute("ktlx",bksktjxService.getKtlxbm());
        /*获取本科生课堂教学信息，存入model*/
        model.addAttribute("bksktjx",bksktjxService.getBksktjxInfo());
        /*获取课堂教学的总工作量*/
        model.addAttribute("ktjxgzlSum", bksktjxService.getBkjxgzlSum(users.getGh()));
        return "classroomteaching";
    }

    @NeedLogin
    @PostMapping("/addClassInfo")
    public String addClassInfo(@ModelAttribute(value = "bksktjxAccpet")BksktjxAccpet bksktjxAccpet, Users users){
        /*获取工号*/
        bksktjxAccpet.setGh(users.getGh());
        /*获取教学工作量*/
        bksktjxAccpet.setJxgzl(GetClassWork.getClassWork(bksktjxAccpet.getJhxs(), bksktjxAccpet.getSfsy(), bksktjxService.getKtlxbmBybm(bksktjxAccpet.getKtlxbm()),bksktjxAccpet.getSkrs()));
        /*存入年份*/
        bksktjxAccpet.setNd(GetYear.getYears());
        /*添加课堂信息*/
        bksktjxService.addClassInfo(bksktjxAccpet);
        return "redirect:classroomteaching";
    }


    @RequestMapping(value = "/deleteClassInfo",method = RequestMethod.GET)
    public String delete(@ModelAttribute(value = "id")Integer id){

        /*删除课堂信息*/
        bksktjxService.deleteClassInfoBybksktjxId(id);
        return "redirect:classroomteaching";
    }

}
