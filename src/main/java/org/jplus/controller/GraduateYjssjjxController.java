package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.service.YjssjjxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.controller
 * @Author: lzh
 * @CreateTime: 2019/11/7
 * @Description: Description
 */
@Controller
public class GraduateYjssjjxController {

    @Autowired
    private YjssjjxService yjssjjxService;

    @RequestMapping("/graduatepractice")
    @NeedLogin
    public String graduatepractice(Model model, Users users){

        /*获取实践类型*/
        model.addAttribute("yjssjlx", yjssjjxService.getSjlx());
        /*获取研究生实践类型的基本信息*/
        System.out.println(yjssjjxService.getYjssjjxJbxx(users.getGh()).toString());
        model.addAttribute("yjssjjxJbxx", yjssjjxService.getYjssjjxJbxx(users.getGh()));
        return "graduatepractice";
    }

    @NeedLogin
    @PostMapping("/updateYjssjjxInfo")
    public String updateInfo(){

        return "redirect:graduatepractice";
    }
}
