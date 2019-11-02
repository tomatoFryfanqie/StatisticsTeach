package org.jplus.controller;

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

    @RequestMapping("/classroomteaching")
    public String getClassTechInfo(Model model){
        /*获取年份。存入model*/
        model.addAttribute("year", GetYear.getYears());
        /*获取课堂类型，存入model*/
        model.addAttribute("ktlx",bksktjxService.getKtlxbm());
        /*获取本科生课堂教学信息，存入model*/
        model.addAttribute("bksktjx",bksktjxService.getBksktjxInfo());
        return "classroomteaching";
    }

    @PostMapping("/addClassInfo")
    public String addClassInfo(@ModelAttribute(value = "bksktjxAccpet")BksktjxAccpet bksktjxAccpet){
        /*获取工号*/
        bksktjxAccpet.setGh(UserContext.getUser().getGh());
        /*获取教学工作量*/
        bksktjxAccpet.setJxgzl(GetClassWork.getClassWork(bksktjxAccpet.getJhxs(), bksktjxAccpet.getSfsy(), bksktjxService.getKtlxbmBybm(bksktjxAccpet.getKtlxbm()),bksktjxAccpet.getSkrs()));
        /*存入年份*/
        bksktjxAccpet.setNd(GetYear.getYears());
        /*添加课堂信息*/
        bksktjxService.addClassInfo(bksktjxAccpet);
        return "redirect:classroomteaching";
    }

    @PostMapping("/deleteClassInfo")
    public String delete(@ModelAttribute(value = "bksktjxAccpet")BksktjxAccpet bksktjxAccpet){

        /*删除课堂信息*/
        bksktjxService.deleteClassInfoBybksktjxId(bksktjxAccpet.getBksktjx());
        return "redirect:classroomteaching";
    }

}
