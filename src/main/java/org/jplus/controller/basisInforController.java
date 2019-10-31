package org.jplus.controller;

import org.jplus.service.jbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
public class basisInforController {

    @Autowired
    private jbxxService jbxxService;

    @RequestMapping("/basicinformation")
    public String getInfo(Model model){
        /*获取院系信息*/
        model.addAttribute("yxType", jbxxService.getYxbmInfo());
        /*获取职务信息*/
        model.addAttribute("zwType",jbxxService.getZwbmInfo());
        /*获取职称信息*/
        model.addAttribute("zcType",jbxxService.getZcbmInfo());
        /*获取岗位信息*/
        model.addAttribute("gwlxType", jbxxService.getGwlxbmInfo());
        /*获取基本信息存到model中*/
        model.addAttribute("basisInfo", jbxxService.getJbxxInfo());
        return "basicinformation";
    }


}
