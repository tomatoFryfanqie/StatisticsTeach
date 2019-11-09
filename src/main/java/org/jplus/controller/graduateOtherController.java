package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.jplus.service.YJSQTJXService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb
 * @date 2019/11/8 - 15:32
 */
@Controller
public class graduateOtherController {

    @Autowired
    private YJSQTJXService yJSQTJXService;

    @RequestMapping("/masterOther")
    @NeedLogin
    public String hello() {
        return "graduateother";
    }

    @RequestMapping("/getNumber")
    @ResponseBody
    @NeedLogin
    public int getYear() {
        return DateUtils.getCurrentYear();
    }

    @RequestMapping("/addMasterOtherTeachWork")
    @ResponseBody
    @NeedLogin
    public void addMasterOtherTeachWorkload(Users users, float workloadOfTeachingSupervision, int proposition, int examining,
                                      int check, int examiner, int invigilator, int checking) {
        YJSQTJX yJSQTJX = new YJSQTJX();
        String gh = users.getGh();
        yJSQTJX.setGh(gh);
        yJSQTJX.setNd(DateUtils.getCurrentYear());
        yJSQTJX.setJxddgzl(workloadOfTeachingSupervision);
        yJSQTJX.setMtfs(proposition);
        yJSQTJX.setStfs(examining);
        yJSQTJX.setJdts(check);
        yJSQTJX.setFsjkcs(examiner);
        yJSQTJX.setYjfs(invigilator);
        double gzl = workloadOfTeachingSupervision + proposition*8 + examining*4 + check*4 + examiner*4 + invigilator*3 + checking*0.3;
        yJSQTJX.setGzl((float)gzl);
        yJSQTJXService.addYJSQTJX(yJSQTJX);
        System.out.println("success");
    }

    @RequestMapping("/getMasterAllQtGzl")
    @ResponseBody
    @NeedLogin
    public float getAllQtGzl() {
        return yJSQTJXService.getAllQtGzl();
    }
}
