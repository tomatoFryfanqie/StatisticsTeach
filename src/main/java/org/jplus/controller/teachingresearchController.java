package org.jplus.controller;

import org.jplus.pojo.teachingresearchInfo.Jxcg;
import org.jplus.service.JxcgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 教学研究控制层
 * @author:zmj
 * @date 2019/10/3116:35
 */
@Controller
public class teachingresearchController {

    @Autowired
    JxcgServiceImpl jxcgService;

//教学成果显示
    @RequestMapping("/teachingresearch")
    public String getInfo(Model model,Integer id){
        model.addAttribute("Jxcgs", jxcgService.getJxcgInfo());
        model.addAttribute("Jxcgdjmcs",jxcgService.getCgdjmcById());
        return "teachingresearch";
    }

//删除教学成果某一列
    @RequestMapping("/delJxcg")
    public String delJxcg(Integer id){
        jxcgService.deleteJxcg(id);
        return "redirect:/teachingresearch";
    }

//添加教学成果某一列
    @RequestMapping("/addJxcg")
    public String addJxcg(@ModelAttribute Jxcg jxcg){
            jxcgService.addJxcg(jxcg);
        return "addJxcg";
    }
}
