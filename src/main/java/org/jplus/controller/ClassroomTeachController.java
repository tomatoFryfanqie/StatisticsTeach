package org.jplus.controller;

import org.jplus.pojo.classTeach.BksktjxAccpet;
import org.jplus.service.BksktjxService;
import org.jplus.utils.YearAndClass;
import org.jplus.utils.GetClassWork;
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
        model.addAttribute("year",YearAndClass.getYears());
        model.addAttribute("ktlx",bksktjxService.getKtlxbm());
        model.addAttribute("bksktjx",bksktjxService.getBksktjxInfo());
        return "classroomteaching";
    }

    @PostMapping("/addClassInfo")
    public String addClassInfo(@ModelAttribute(value = "bksktjxAccpet")BksktjxAccpet bksktjxAccpet){
        /*取出工号*/
        String gh = "00000001";
        bksktjxAccpet.setGh(gh);
        bksktjxAccpet.setJxgzl(GetClassWork.getClassWork(bksktjxAccpet.getJhxs(), bksktjxAccpet.getSfsy(), bksktjxService.getKtlxbmBybm(bksktjxAccpet.getKtlxbm()),bksktjxAccpet.getSkrs()));
        bksktjxAccpet.setNd(YearAndClass.getYears());
        bksktjxService.addClassInfo(bksktjxAccpet);
        System.out.println(bksktjxAccpet.toString());
        return "redirect:classroomteaching";
    }

    @PostMapping("/deleteClassInfo")
    public String delete(@ModelAttribute(value = "bksktjxAccpet")BksktjxAccpet bksktjxAccpet){

        bksktjxService.deleteClassInfoBybksktjxId(bksktjxAccpet.getBksktjx());
        return "redirect:classroomteaching";
    }

}
