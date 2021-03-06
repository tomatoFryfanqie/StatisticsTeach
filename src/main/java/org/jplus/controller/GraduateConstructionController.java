package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJSAccept;
import org.jplus.service.JbjsyxkjsService;
import org.jplus.service.TjztService;
import org.jplus.utils.GetWorkLoad;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GraduateConstructionController {
    @Autowired
    JbjsyxkjsService jbjsyxkjsService;

    @Autowired
    private TjztService tjztService;


    @NeedLogin
    @RequestMapping("/graduateconstruction")
    public String getQualityEngineeringInfo(Model model, Users users) {
        //获取年份
        model.addAttribute("year", GetYear.getYears());
        if (jbjsyxkjsService.getWorkLoad(users.getGh()) == null) {
            model.addAttribute("sumOfWorkload", 0);
            model.addAttribute("sfzxpyfa", 0);
            model.addAttribute("kddgms", 0);
            model.addAttribute("sydgms", 0);
        } else {
            if (jbjsyxkjsService.getJBJSYXKJSInfo(users.getGh())!= null){
                model.addAttribute("sumOfWorkload", jbjsyxkjsService.getWorkLoad(users.getGh()));
                model.addAttribute("sfzxpyfa", jbjsyxkjsService.getJBJSYXKJSInfo(users.getGh()).getSfzxpyfa());
                model.addAttribute("kddgms", jbjsyxkjsService.getJBJSYXKJSInfo(users.getGh()).getKddgms());
                model.addAttribute("sydgms", jbjsyxkjsService.getJBJSYXKJSInfo(users.getGh()).getSydgms());
            }else {
                model.addAttribute("sumOfWorkload", 0);
                model.addAttribute("sfzxpyfa", 0);
                model.addAttribute("kddgms", 0);
                model.addAttribute("sydgms", 0);
            }
        }
        model.addAttribute("hidden",tjztService.getTjzt(users.getGh()).getTjzt());
        return "graduateconstruction";
    }

    @NeedLogin
    @RequestMapping("/addGraduateConstruction")
    public String addGraduateConstruction(@ModelAttribute(value = "jBJSYXKJSAccept") JBJSYXKJSAccept jbjsyxkjsAccept, Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行添加操作*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            // 没有数据就添加
            if (jbjsyxkjsService.getWorkLoad(users.getGh()) == null) {
                jbjsyxkjsAccept.setGh(users.getGh());
                jbjsyxkjsAccept.setNd(GetYear.getYears());
                jbjsyxkjsAccept.setGzl(GetWorkLoad.getGraduateConstructionWorkload(jbjsyxkjsAccept.getSfzxpyfa(), jbjsyxkjsAccept.getKddgms(), jbjsyxkjsAccept.getSydgms()));
                jbjsyxkjsService.addGraduateConstruction(jbjsyxkjsAccept);
            } else {
                jbjsyxkjsAccept.setGh(users.getGh());
                jbjsyxkjsAccept.setNd(GetYear.getYears());
                jbjsyxkjsAccept.setGzl(GetWorkLoad.getGraduateConstructionWorkload(jbjsyxkjsAccept.getSfzxpyfa(), jbjsyxkjsAccept.getKddgms(), jbjsyxkjsAccept.getSydgms()));
                jbjsyxkjsService.updateGraduateConstruction(jbjsyxkjsAccept);
            }
        }

        return "redirect:/graduateconstruction";
    }

    // 没有用到 ，将更新的代码放到添加的判断中，处理添加请求，如果有数据，那么久更新
    @NeedLogin
    @RequestMapping("/updateGraduateConstruction")
    public String updateGraduateConstruction(@ModelAttribute(value = "jBJSYXKJSAccept") JBJSYXKJSAccept jbjsyxkjsAccept, Users users) {
        /*如果提交状态表的提交状态处于0：未提交状态，则可以进行添加操作*/
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            jbjsyxkjsAccept.setGzl(GetWorkLoad.getGraduateConstructionWorkload(jbjsyxkjsAccept.getSfzxpyfa(), jbjsyxkjsAccept.getKddgms(), jbjsyxkjsAccept.getSydgms()));
            jbjsyxkjsService.updateGraduateConstruction(jbjsyxkjsAccept);
        }
        return "redirect:/graduateconstruction";
    }
}
