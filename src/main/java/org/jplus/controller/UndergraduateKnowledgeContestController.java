package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.JSJS;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.bks.Sxlx;
import org.jplus.pojo.queryVo.JsjsVo;
import org.jplus.pojo.queryVo.ZdxsjsVo;
import org.jplus.service.JSJSService;
import org.jplus.service.TjztService;
import org.jplus.service.ZDXSJSService;
import org.jplus.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 13:09
 */
@Controller
public class UndergraduateKnowledgeContestController {

    @Autowired
    private TjztService tjztService;

    @Autowired
    private ZDXSJSService zDXSJSService;

    @Autowired
    private JSJSService jSJSService;

    @RequestMapping("/know")
    @NeedLogin
    public String hello(Model model,Users users) {
        //List<JSJS> result = jSJSService.getTeacherCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        //List<ZDXSJS> list = zDXSJSService.getStudentCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        List<ZdxsjsVo> list = zDXSJSService.getStudentCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        for(int i = 0; i < list.size(); i++) {
            int jbbm = list.get(i).getJsjbbm();
            if(jbbm == 1) {
                list.get(i).setJsjbmc("国家级");
            }else if(jbbm == 2) {
                list.get(i).setJsjbmc("省级");
            }else if(jbbm == 3){
                list.get(i).setJsjbmc("校级");
            }
            int lbbm = list.get(i).getJslbbm();
            if(lbbm == 1) {
                list.get(i).setJslbmc("A类师范生教学技能竞赛");
            }else if(lbbm == 2) {
                list.get(i).setJslbmc("B类师范生教学技能竞赛");
            }else if(lbbm == 3) {
                list.get(i).setJslbmc("A类其他竞赛");
            }else if(lbbm == 4) {
                list.get(i).setJslbmc("B类其他竞赛");
            }
        }
        List<JsjsVo> result = jSJSService.getTeacherCompetitionList(users.getGh(), DateUtils.getCurrentYear());
        // 向竞赛等级编码表中查询
        for(int i = 0; i < result.size(); i++) {
            String jsdjmc = jSJSService.getcompetitionLevelByBM(result.get(i).getJsdjbm());
            result.get(i).setJsdjmc(jsdjmc);
            int xsbm = result.get(i).getJsxsbm();
            if(xsbm == 1) {
                result.get(i).setJsxsmc("讲课");
            }else if(xsbm == 2) {
                result.get(i).setJsxsmc("课件");
            }else if(xsbm == 3) {
                result.get(i).setJsxsmc("微课");
            }
        }

        ZDXSLW zDXSLW = zDXSJSService.findZDXSLWByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        model.addAttribute("allStudentCompetitionList", list);
        model.addAttribute("allTeacherCompetitionList", result);
        model.addAttribute("zDXSLW", zDXSLW);
        return "knowledgecontest";
    }

    @NeedLogin
    @RequestMapping("/getYearNum")
    @ResponseBody
    public int getYear() {
        return DateUtils.getCurrentYear();
    }

    @NeedLogin
    @RequestMapping("/addCompetition")
    @ResponseBody
    public void addStudentContest(String contestName, Integer competition,  Integer contestLevel, Integer studentNum, Users users) {
        /**
         * 通过竞赛名称contestName、竞赛类别competitionform和指导学生人数studentNum来获取gzl
         * */
        ZDXSJS zDXSJS = new ZDXSJS();
        // 这里的工号可以从session中获取
        String gh = users.getGh();
        zDXSJS.setGh(gh);
        zDXSJS.setNd(DateUtils.getCurrentYear());
        zDXSJS.setJsmc(contestName);
        zDXSJS.setJslbbm(competition);
        zDXSJS.setJsjbbm(contestLevel);
        zDXSJS.setZdxsrs(studentNum);
        zDXSJS.setJsxscc(1);
        /**
         * 根据传过来的competition、contestLevel来确定工作量
         *      setGzl = 工作量 * studentNum
         *      测试成功
         * */
        Float gzl = zDXSJSService.getGzl(competition, contestLevel);
        gzl = gzl * studentNum;
        zDXSJS.setGzl(gzl);
        // 添加到数据库
        zDXSJSService.addZDXSJS(zDXSJS);
    }

    /**
     * 一下是教师教学能力竞赛获奖情况的工作量统计
     * 测试成功
     * */
    @NeedLogin
    @RequestMapping("/addTeacherCompetition")
    @ResponseBody
    public void addTeacherCompetition(String teacherCompetitionName, Integer teacherCompetitioncategory, Integer teacherCompetitionform, Users users) {
        JSJS jSJS = new JSJS();
        // 这里的工号可以从session中获取
        String gh = users.getGh();
        jSJS.setGh(gh);
        jSJS.setNd(DateUtils.getCurrentYear());
        jSJS.setJsmc(teacherCompetitionName);
        jSJS.setJsdjbm(teacherCompetitioncategory);
        jSJS.setJsxsbm(teacherCompetitionform);
        /**
         * 根据传过来的teacherCompetitioncategory（竞赛等级）、teacherCompetitionform（竞赛形式）
         * */
        Integer gzl = jSJSService.getGzl(teacherCompetitioncategory);
        if(teacherCompetitionform != 1) {
            gzl /= 2;
        }
        jSJS.setGzl(gzl);
        // 添加到数据库
        jSJSService.addJSJS(jSJS);
    }


    /**
     * 教师指导学生学士学位论文获奖的信息
     *      一位老师一年应该只有一条记录，因此在添加的时候如果数据库没有记录则添加有则更新
     * */
    @NeedLogin
    @RequestMapping("/saveCount")
    @ResponseBody
    public void save(Integer slwNum, Integer xlwNum, Users users) {
        ZDXSLW zDXSLW = new ZDXSLW();
        String gh = users.getGh();
        zDXSLW.setGh(gh);
        zDXSLW.setNd(DateUtils.getCurrentYear());
        zDXSLW.setSylwrs(slwNum);
        zDXSLW.setXylwrs(xlwNum);
        float gzl = slwNum * 30 + xlwNum * 10;
        zDXSLW.setGzl(gzl);
        // 判断数据库中是否有记录
        Integer count = zDXSJSService.isOnlyForOneYear(users.getGh(), DateUtils.getCurrentYear());
        System.out.println(count);
        if(count == 0) {
            // 添加
            jSJSService.addZDXSLW(zDXSLW);
        }else {
            // 更新
            jSJSService.updateZDXSLW(zDXSLW);
        }
    }

    /**
     * 获取指导学生竞赛的工作两个小计
     * */
    @NeedLogin
    @RequestMapping("/getStudentCompetitionGzl")
    @ResponseBody
    public Float getStudentCompetitionGzl(Users users) {
        if(zDXSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear()) != null) {
            return zDXSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear());
        }else {
            return 0.0f;
        }
    }

    /**
     * 获取教师技能竞赛的工作量小计
     * */
    @NeedLogin
    @RequestMapping("/getTeacherCompetitionGzl")
    @ResponseBody
    public Float getTeacherCompetitionGzl(Users users) {
        if(jSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear()) != null) {
            return jSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear());
        }else {
            return 0.0f;
        }
    }

    /**
     * 获取优秀论文的工作量小计
     * */
    @NeedLogin
    @RequestMapping("/getLwGzl")
    @ResponseBody
    public Float getLwGzl(Users users) {
        return jSJSService.getAllLwGzl(users.getGh(), DateUtils.getCurrentYear());
    }

    /**
     * 工作量总计
     * */
    @NeedLogin
    @RequestMapping("/getAllGzl")
    @ResponseBody
    public Float getAllGzl(Users users) {
        float result = 0;
        if(zDXSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear()) != null) {
            result += zDXSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear());
        }
        if(jSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear()) != null) {
            result += jSJSService.getAllGzl(users.getGh(), DateUtils.getCurrentYear());
        }
        if(jSJSService.getAllLwGzl(users.getGh(), DateUtils.getCurrentYear()) != null) {
            result += jSJSService.getAllLwGzl(users.getGh(), DateUtils.getCurrentYear());
        }
        return result;
    }

    /**
     * 删除本科生竞赛
     */
    @NeedLogin
    @RequestMapping(value = "/deleteUndergraduate")
    public String delete(@ModelAttribute(value = "id") Integer id, Users users) {
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            // 未提交，可以删除
            zDXSJSService.remove(id);
        }
        return "redirect:know";
    }

    /**
     * 删除教师技能竞赛
     */
    @NeedLogin
    @RequestMapping(value = "/deleteTeacherCompetition")
    public String deleteTeacherCompetition(@ModelAttribute(value = "id") Integer id, Users users) {
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            // 未提交，可以删除
            jSJSService.remove(id);
        }
        return "redirect:know";
    }
}
