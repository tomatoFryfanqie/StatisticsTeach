package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.zlgc.ZlgcAccept;
import org.jplus.service.ZlgcService;
import org.jplus.utils.CalculateQualityEngineerWorkLoad;
import org.jplus.utils.UserContext;

import org.jplus.utils.YearAndClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: init
 * @description:
 * @author: MH
 * @create: 2019-10-30 21:36
 **/
@Controller
public class QualityEngineerController {
    @Autowired
    ZlgcService zlgcService;

    @NeedLogin
    @RequestMapping("/qualityengineering")
    public String getQualityEngineeringInfo(Model model) {
//        model.addAttribute("WorkLoad")
        model.addAttribute("zlgc", zlgcService.getZlgcInfo());
        return "qualityengineering";
    }

    @NeedLogin
    @PostMapping("/addZlgc")
    public String addZlgcInfo(@ModelAttribute(value = "zlgcAccept") ZlgcAccept zlgcAccept) {
        zlgcAccept.setNd(zlgcAccept.getNd());
        zlgcAccept.setGh(UserContext.getUser().getGh());
        zlgcAccept.setGzl(CalculateQualityEngineerWorkLoad.calculateWorkLoad(zlgcAccept.getXmlxbm(), zlgcAccept.getJb(), zlgcAccept.getXmpm(), zlgcAccept.getZrs()));
        zlgcService.addZlgcInfo(zlgcAccept);
        return "redirect:/qualityengineering";
    }

    @NeedLogin
    @RequestMapping("/deleteZlgcInfo")
    public String deleteZlgcInfo(@ModelAttribute(value = "id") Integer id) {
        zlgcService.deleteZlgcInfo(id);
        return "redirect:/qualityengineering";
    }

    @NeedLogin
    @RequestMapping("updateZlgcInfo")
    public String updateZlgcInfo(@ModelAttribute("zlgcAccept") ZlgcAccept zlgcAccept) {
        zlgcAccept.setGzl(CalculateQualityEngineerWorkLoad.calculateWorkLoad(zlgcAccept.getXmlxbm(), zlgcAccept.getJb(), zlgcAccept.getXmpm(), zlgcAccept.getZrs()));
        zlgcService.updateZlgcInfo(zlgcAccept);
        return "redirect:/qualityengineering";
    }

}
