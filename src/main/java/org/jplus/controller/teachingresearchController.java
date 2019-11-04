package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.teachingresearchInfo.Jxcg;
import org.jplus.service.JxcgServiceImpl;
import org.jplus.utils.GetWorkCount;
import org.jplus.utils.GetYear;
import org.jplus.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    @NeedLogin
    @RequestMapping("/teachingresearch")
    public String getInfo(Model model, Integer id,Users user){
        model.addAttribute("Jxcgs", jxcgService.getJxcgInfo());
        model.addAttribute("Jxcgdjs",jxcgService.getJxcgdjInfo());
        model.addAttribute("user",user.getGh());
        model.addAttribute("year",GetYear.getYears());
        return "teachingresearch";
    }

//删除教学成果某一列
    @RequestMapping("/delJxcg")
    public String delJxcg(Integer id){
        jxcgService.deleteJxcg(id);
        return "redirect:/teachingresearch";
    }

//添加教学成果某一列
    @PostMapping("/addJxcg")
    public String addJxcg(@ModelAttribute(value =
            "jxcg") Jxcg jxcg){
        //获取工号
        jxcg.setGh(UserContext.getUser().getGh());
        //获取工作量
        jxcg.setJxcggzl(GetWorkCount.GetWorkCount(jxcg.getJxcgzrs(),jxcg.getXmpm(),jxcg.getJxcgid());
        //存入年份
        jxcg.setNd(GetYear.getYears());
        //添加信息
       jxcgService.addJxcg(jxcg);
        return "redirect:/teachingresearch";
    }


}
