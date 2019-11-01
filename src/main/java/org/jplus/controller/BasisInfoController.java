package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.service.JbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private JbxxService JbxxService;

    @NeedLogin
    @RequestMapping("/basicinformation")
    public String getInfo(Model model){
        /*获取院系信息*/
        model.addAttribute("yxType", JbxxService.getYxbmInfo());
        /*获取职务信息*/
        model.addAttribute("zwType",JbxxService.getZwbmInfo());
        /*获取职称信息*/
        model.addAttribute("zcType",JbxxService.getZcbmInfo());
        /*获取岗位信息*/
        model.addAttribute("gwlxType", JbxxService.getGwlxbmInfo());
        /*获取基本信息存到model中*/
        model.addAttribute("basisInfo", JbxxService.getJbxxInfo());
        return "basicinformation";
    }


}
