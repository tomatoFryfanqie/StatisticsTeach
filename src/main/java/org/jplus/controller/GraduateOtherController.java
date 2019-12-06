package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.jplus.service.TjztService;
import org.jplus.service.YJSQTJXService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GraduateOtherController {

    @Autowired
    private TjztService tjztService;

    @Autowired
    private YJSQTJXService yJSQTJXService;

    @RequestMapping("/masterOther")
    @NeedLogin
    public String hello(Model model, Users users) {
        YJSQTJX yJSQTJX = yJSQTJXService.findYJSQTJXByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        model.addAttribute("yJSQTJX", yJSQTJX);
        model.addAttribute("hidden",tjztService.getTjzt(users.getGh()).getTjzt());
        return "graduateother";
    }

    @RequestMapping("/getNumber")
    @ResponseBody
    @NeedLogin
    public Integer getYear() {
        return DateUtils.getCurrentYear();
    }

    @RequestMapping("/addMasterOtherTeachWork")
    @NeedLogin
    @ResponseBody
    public void addMasterOtherTeachWorkload(Users users, Float workloadOfTeachingSupervision, Integer proposition, Integer examining,
                                            Integer check, Integer examiner, Integer invigilator, Integer checking) {
        YJSQTJX yJSQTJX = new YJSQTJX();
        String gh = users.getGh();
        yJSQTJX.setGh(gh);
        yJSQTJX.setNd(DateUtils.getCurrentYear());
        yJSQTJX.setJxddgzl(workloadOfTeachingSupervision);
        yJSQTJX.setMtfs(proposition);
        yJSQTJX.setStfs(examining);
        yJSQTJX.setJdts(check);
        yJSQTJX.setFsmskg(examiner);
        yJSQTJX.setFsjkcs(invigilator);
        yJSQTJX.setYjfs(checking);
        double gzl = 0;
        if(checking <= 20 && checking >0) {
            gzl = workloadOfTeachingSupervision + proposition*8 + examining*4 + check*4 + examiner*4 + invigilator*3 + 20*0.3;
        }else {
            gzl = workloadOfTeachingSupervision + proposition*8 + examining*4 + check*4 + examiner*4 + invigilator*3 + checking*0.3;
        }

        yJSQTJX.setGzl((float) gzl);
        // 无则添加，有则更新
        int count = yJSQTJXService.isOnlyForOneYear(users.getGh(), DateUtils.getCurrentYear());

        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            // 未提交，可以修改
            if(count == 0) {
                // 添加
                yJSQTJXService.addYJSQTJX(yJSQTJX);
            }else {
                // 更新
                yJSQTJXService.updateYJSQTJX(yJSQTJX);
            }
        }
    }

    @RequestMapping("/getMasterAllQtGzl")
    @ResponseBody
    @NeedLogin
    public Float getAllQtGzl(Users users) {
        return yJSQTJXService.getAllQtGzl(users.getGh(), DateUtils.getCurrentYear());
    }
}
