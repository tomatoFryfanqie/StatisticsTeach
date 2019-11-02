package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.basisInfo.Jbxx;
import org.jplus.pojo.basisInfo.JbxxAccpet;
import org.jplus.service.JbxxService;
import org.jplus.utils.GetRatedWorkload;
import org.jplus.utils.GetRatedTeachTime;
import org.jplus.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.controller
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
@Controller
public class BasisInfoController {

    @Autowired
    private JbxxService jbxxService;

    @NeedLogin
    @RequestMapping("/basicinformation")
    public String getInfo(Model model){
        /*获取院系信息,做下拉列表*/
        model.addAttribute("yxType", jbxxService.getYxbmInfo());
        /*获取职务信息,做下拉列表*/
        model.addAttribute("zwType",jbxxService.getZwbmInfo());
        /*获取职称信息,做下拉列表*/
        model.addAttribute("zcType",jbxxService.getZcbmInfo());
        /*获取岗位信息,做下拉列表*/
        model.addAttribute("gwlxType", jbxxService.getGwlxbmInfo());
        /*获取基本信息存到model中*/
        model.addAttribute("basisInfo", jbxxService.getJbxxInfo(UserContext.getUser().getGh()));
        return "basicinformation";
    }

    @PostMapping("/updateBasisInfo")
    public String updateJbxxInfo(@ModelAttribute(value = "jbxxAccpet") JbxxAccpet jbxxAccpet){

        /*获取额定工作量并存入数据库*/
        jbxxAccpet.setEdgzl(GetRatedWorkload.getRatedWorkload(jbxxAccpet.getZcbm(),jbxxAccpet.getGwlxbm(),jbxxAccpet.getSfxrz()));
        /*获取本科生最低授课工作量*/
        jbxxAccpet.setBkszdsk(GetRatedTeachTime.getTeachTime(jbxxAccpet.getZcbm(), jbxxAccpet.getGwlxbm()));
        /*更新部分基本信息*/
        jbxxService.updateBasisInfo(jbxxAccpet);
        return "redirect:basicinformation";
    }
}
