package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.QTJXGZ;
import org.jplus.service.QTJXGZService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String hello() {
        return "otheractivities";
    }

    @RequestMapping("/getYearNumber")
    @ResponseBody
    @NeedLogin
    public int getYear() {
        return DateUtils.getCurrentYear();
    }

    @RequestMapping("/addOtherTeachWork")
    @ResponseBody
    @NeedLogin
    public void addOtherTeachWorkload(float workloadOfTeachingSupervision, int numberOfStudentsAssisted, int guideYoungTeachers,
                                      int reviseTalentTrainingPlan, int prepareCourseSyllabusCount, int compilingExperimentalSyllabusCount) {
        QTJXGZ qTJXGZ = new QTJXGZ();
        qTJXGZ.setNd(DateUtils.getCurrentYear());
        qTJXGZ.setDdgzl(workloadOfTeachingSupervision);
        qTJXGZ.setBfxsrs(numberOfStudentsAssisted);
        qTJXGZ.setZdqnjs(guideYoungTeachers);
        qTJXGZ.setXdrcpyfa(reviseTalentTrainingPlan);
        qTJXGZ.setKcdgms(prepareCourseSyllabusCount);
        qTJXGZ.setSydgms(compilingExperimentalSyllabusCount);
        float allGzl = workloadOfTeachingSupervision + guideYoungTeachers*10 + numberOfStudentsAssisted*10 + reviseTalentTrainingPlan*20 + prepareCourseSyllabusCount*10 + reviseTalentTrainingPlan*10;
        qTJXGZ.setQtgzl(allGzl);
        qTJXGZService.addQTJXGZ(qTJXGZ);
    }

    @RequestMapping("/getTeachStudentCount")
    @ResponseBody
    @NeedLogin
    public int getTeachStudentCount(int numberOfStudentsAssisted) {
        return numberOfStudentsAssisted * 10;
    }

    @RequestMapping("/getTeachYoungTeacherCount")
    @ResponseBody
    @NeedLogin
    public int getTeachYoungTeacherCount(int guideYoungTeachers) {
        return guideYoungTeachers * 10;
    }


    @RequestMapping("/getUndertakeCount")
    @ResponseBody
    @NeedLogin
    public int getUndertakeCount(int reviseTalentTrainingPlan, int prepareCourseSyllabusCount, int compilingExperimentalSyllabusCount) {
        return reviseTalentTrainingPlan*20 + prepareCourseSyllabusCount*10 + compilingExperimentalSyllabusCount*10;
    }

    // 获取其他教学活动的总工作量
    @RequestMapping("/getAllQtGzl")
    @ResponseBody
    @NeedLogin
    public float getAllQtGzl() {
        return qTJXGZService.getAllQtGzl();
    }
}
