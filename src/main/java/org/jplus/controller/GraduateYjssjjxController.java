package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.pojo.yjssjjx.YjssjjxAccpet;
import org.jplus.service.TjztService;
import org.jplus.service.YjssjjxService;
import org.jplus.utils.GetWorkLoad;
import org.jplus.utils.GetYear;
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
 * @CreateTime: 2019/11/7
 * @Description: Description
 */
@Controller
public class GraduateYjssjjxController {

    @Autowired
    private YjssjjxService yjssjjxService;

    @Autowired
    private TjztService tjztService;

    @RequestMapping("/graduatepractice")
    @NeedLogin
    public String graduatepractice(Model model, Users users){

        /*获取实践类型*/
        model.addAttribute("yjssjlx", yjssjjxService.getSjlx());
        /*获取研究生实践类型的基本信息*/
        Yjssjjx jbxx = yjssjjxService.getYjssjjxJbxx(users.getGh());
        if(jbxx!=null) {
            /*获取指导学生次数工作量（显示）*/
            model.addAttribute("zdxshdcsGzl", GetWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(users.getGh()).getZdxshdcs()));
            /*获取自行增加的工作量*/
            model.addAttribute("ZtGzl", jbxx.getGzl() - jbxx.getRcgzl() - GetWorkLoad.getForYjsWorkLoad(yjssjjxService.getYjssjjxJbxx(users.getGh()).getZdxshdcs()));
        }
        model.addAttribute("yjssjjxJbxx", jbxx);
        return "graduatepractice";
    }

    @NeedLogin
    @PostMapping("/updateYjssjjxInfo")
    public String updateInfo(@ModelAttribute(value = "YjssjjxAccpet")YjssjjxAccpet yjssjjxAccpet,Users users){
        /*先判断提交状态表的提交状态是否为0：未提交状态，为0则可以进行更新操作*/
        if(tjztService.getTjzt(users.getGh()).getTjzt()==0){
            /*如果数据库没有此工号的数据，则新增加一条数据*/
            if(yjssjjxService.getYjssjjxJbxx(users.getGh())==null){
                yjssjjxService.addYjssjjxInfo(users.getGh());
            }
            /*获取年度*/
            yjssjjxAccpet.setNd(GetYear.getYears());
            /*获取日常工作量*/
            yjssjjxAccpet.setRcgzl(GetWorkLoad.getDayWorkLoad(yjssjjxAccpet.getSjts1(),yjssjjxAccpet.getSjts2(),yjssjjxAccpet.getSjts3()));
            /*自输入工作量*/
            if(yjssjjxAccpet.getGzl()==null){
                yjssjjxAccpet.setGzl(0f);
            }
            /*获取总工作量,1.日常工作量，2.指导工作量,3 自输入工作量*/
            yjssjjxAccpet.setGzl(yjssjjxAccpet.getRcgzl()+GetWorkLoad.getForYjsWorkLoad(yjssjjxAccpet.getZdxshdcs())+yjssjjxAccpet.getGzl());
            /*更新信息*/
            yjssjjxAccpet.setGh(users.getGh());
            yjssjjxService.updateYjsSxJbxx(yjssjjxAccpet);
        }
        return "redirect:graduatepractice";
    }
}
