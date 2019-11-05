package org.jplus.controller;

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

    @RequestMapping("/qualityengineering")
    public String getQualityEngineeringInfo(Model model) {
        model.addAttribute("zlgc", zlgcService.getZlgcInfo());
        return "qualityengineering";
    }

    @PostMapping("/addZlgc")
    public String addZlgcInfo(@ModelAttribute(value = "zlgcAccept") ZlgcAccept zlgcAccept) {
        System.out.println("从表单获取的数据" + zlgcAccept);
        zlgcAccept.setNd(YearAndClass.getYears());
        zlgcAccept.setGh(UserContext.getUser().getGh());
        zlgcAccept.setZlgcgzl(CalculateQualityEngineerWorkLoad.calculateWorkLoad(zlgcAccept.getXmlxbm(), zlgcAccept.getJb(), zlgcAccept.getXmpm(), zlgcAccept.getXmzrs()));
        System.out.println("计算完善后的数据：" + zlgcAccept);
        zlgcService.addZlgcInfo(zlgcAccept);
        return "redirect:/qualityengineering";
    }

    @RequestMapping("/deleteZlgcInfo")
    public String deleteZlgcInfo(@ModelAttribute(value = "id") Integer id) {
        System.out.println("将要删除的ID" + id);
        zlgcService.deleteZlgcInfo(id);
        return "redirect:/qualityengineering";
    }

    @RequestMapping("updateZlgcInfo")
    public String updateZlgcInfo(@ModelAttribute("zlgcAccept") ZlgcAccept zlgcAccept) {
        System.out.println("从修改表单获取的数据" + zlgcAccept);
        zlgcAccept.setZlgcgzl(CalculateQualityEngineerWorkLoad.calculateWorkLoad(zlgcAccept.getXmlxbm(), zlgcAccept.getJb(), zlgcAccept.getXmpm(), zlgcAccept.getXmzrs()));
        System.out.println("计算之后的数据" + zlgcAccept);
        zlgcService.updateZlgcInfo(zlgcAccept);
        return "redirect:/qualityengineering";
    }
}
