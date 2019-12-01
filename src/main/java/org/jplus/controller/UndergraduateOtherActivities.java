package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.QTJXGZ;
import org.jplus.pojo.Users;
import org.jplus.service.QTJXGZService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb
 * @date 2019/11/1 - 10:48
 */
@Controller
public class UndergraduateOtherActivities {

    @Autowired
    private QTJXGZService qTJXGZService;

    @RequestMapping("/other")
    @NeedLogin
    public String hello(Model model, Users users) {
        QTJXGZ qTJXGZ = qTJXGZService.findQTJXGZByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        model.addAttribute("qTJXGZ", qTJXGZ);
        return "otheractivities";
    }

    @RequestMapping("/getYearNumber")
    @ResponseBody
    @NeedLogin
    public Integer getYear() {
        return DateUtils.getCurrentYear();
    }

    @RequestMapping("/addOtherTeachWork")
    @NeedLogin
    @ResponseBody
    public void addOtherTeachWorkload(Users users, Float workloadOfTeachingSupervision, Integer numberOfStudentsAssisted, Integer guideYoungTeachers,
                                      Integer reviseTalentTrainingPlan, Integer prepareCourseSyllabusCount, Integer compilingExperimentalSyllabusCount) {
        System.out.println(compilingExperimentalSyllabusCount);
        QTJXGZ qTJXGZ = new QTJXGZ();
        String gh = users.getGh();
        qTJXGZ.setGh(gh);
        qTJXGZ.setNd(DateUtils.getCurrentYear());
        qTJXGZ.setDdgzl(workloadOfTeachingSupervision);
        qTJXGZ.setBfxsrs(numberOfStudentsAssisted);
        qTJXGZ.setZdqnjsrs(guideYoungTeachers);
        qTJXGZ.setXdrcpyfa(reviseTalentTrainingPlan);
        qTJXGZ.setKcdgms(prepareCourseSyllabusCount);
        qTJXGZ.setSydgms(compilingExperimentalSyllabusCount);
        Float allGzl = workloadOfTeachingSupervision + guideYoungTeachers*10 + numberOfStudentsAssisted*10 + reviseTalentTrainingPlan*20 + prepareCourseSyllabusCount*10 + compilingExperimentalSyllabusCount*10;
        qTJXGZ.setQtgzl(allGzl);
        // 无则添加，有则更新
        Integer count = qTJXGZService.isOnlyForOneYear(users.getGh(), DateUtils.getCurrentYear());
        System.out.println(count);
        if(count == 0 || count == null) {
            // 添加
            qTJXGZService.addQTJXGZ(qTJXGZ);
        }else {
            // 更新
            qTJXGZService.updateQTJXGZ(qTJXGZ);
        }
    }

    @RequestMapping("/getTeachStudentCount")
    @ResponseBody
    @NeedLogin
    public Integer getTeachStudentCount(Integer numberOfStudentsAssisted) {
        return numberOfStudentsAssisted * 10;
    }

    @RequestMapping("/getTeachYoungTeacherCount")
    @ResponseBody
    @NeedLogin
    public Integer getTeachYoungTeacherCount(Integer guideYoungTeachers) {
        return guideYoungTeachers * 10;
    }


    @RequestMapping("/getUndertakeCount")
    @ResponseBody
    @NeedLogin
    public Integer getUndertakeCount(Integer reviseTalentTrainingPlan, Integer prepareCourseSyllabusCount, Integer compilingExperimentalSyllabusCount) {
        System.out.println(prepareCourseSyllabusCount);
        return reviseTalentTrainingPlan*20 + prepareCourseSyllabusCount*10 + compilingExperimentalSyllabusCount*10;
    }

    // 获取其他教学活动的总工作量
    @RequestMapping("/getAllQtGzl")
    @ResponseBody
    @NeedLogin
    public Float getAllQtGzl(Users users) {
        Float result = qTJXGZService.getAllQtGzl(users.getGh(), DateUtils.getCurrentYear());
        System.out.println(result);
        if(result == null) {
            return 0.0f;
        }
        return result;
    }
}
