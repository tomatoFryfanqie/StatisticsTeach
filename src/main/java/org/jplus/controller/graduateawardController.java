package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.jplus.pojo.queryVo.ZdxsjsVo;
import org.jplus.service.TjztService;
import org.jplus.service.ZDSSLWService;
import org.jplus.service.ZDXSJSService;
import org.jplus.utils.DateUtils;
import org.jplus.utils.GetWorkLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wb
 * @date 2019/11/8 - 9:38
 */
@Controller
public class graduateawardController {

    @Autowired
    private TjztService tjztService;

    @Autowired
    private ZDXSJSService zDXSJSService;

    @Autowired
    private ZDSSLWService zDSSLWService;

    private static final String GRADUATE_JSJBMC_COUNTRY = "国家级";
    private static final String GRADUATE_JSJBMC_PROVINCE = "省级";
    private static final String GRADUATE_JSJBMC_SCHOOL = "校级";

    private static final String GRADUATE_JSLBMC_ANORMAL = "A类师范生教学技能竞赛";
    private static final String GRADUATE_JSLBMC_BNORMAL = "B类师范生教学技能竞赛";
    private static final String GRADUATE_JSLBMC_AOTHER = "A类其他竞赛";
    private static final String GRADUATE_JSLBMC_BOTHER = "B类其他竞赛";

    @NeedLogin
    @RequestMapping("/masterKnow")
    public String hello(Model model, Users users) {
        //List<ZDXSJS> list = zDXSJSService.getStudentCompetitionList2(users.getGh(), DateUtils.getCurrentYear());
        ZDSSLW zDSSLW = zDSSLWService.findZDSSLWByGhAndYear(users.getGh(), DateUtils.getCurrentYear());
        List<ZdxsjsVo> list = zDXSJSService.getStudentCompetitionList2(users.getGh(), DateUtils.getCurrentYear());
        for(int i = 0; i < list.size(); i++) {
            int jbbm = list.get(i).getJsjbbm();
            if(jbbm == 1) {
                list.get(i).setJsjbmc(GRADUATE_JSJBMC_COUNTRY);
            }else if(jbbm == 2) {
                list.get(i).setJsjbmc(GRADUATE_JSJBMC_PROVINCE);
            }else if(jbbm == 3){
                list.get(i).setJsjbmc(GRADUATE_JSJBMC_SCHOOL);
            }
            int lbbm = list.get(i).getJslbbm();
            if(lbbm == 1) {
                list.get(i).setJslbmc(GRADUATE_JSLBMC_ANORMAL);
            }else if(lbbm == 2) {
                list.get(i).setJslbmc(GRADUATE_JSLBMC_BNORMAL);
            }else if(lbbm == 3) {
                list.get(i).setJslbmc(GRADUATE_JSLBMC_AOTHER);
            }else if(lbbm == 4) {
                list.get(i).setJslbmc(GRADUATE_JSLBMC_BOTHER);
            }
        }
        model.addAttribute("allStudentCompetitionList", list);
        model.addAttribute("zDSSLW", zDSSLW);
        return "graduateaward";
    }

    @NeedLogin
    @RequestMapping("/addMasterCompetition")
    @ResponseBody
    public void addMasterStudentContest(String contestName, Integer competition,  Integer contestLevel, Integer studentNum, Users users) {
        ZDXSJS zDXSJS = new ZDXSJS();
        // 这里的工号可以从session中获取
        String gh = users.getGh();
        zDXSJS.setGh(gh);
        zDXSJS.setNd(DateUtils.getCurrentYear());
        zDXSJS.setJsmc(contestName);
        zDXSJS.setJslbbm(competition);
        zDXSJS.setJsjbbm(contestLevel);
        zDXSJS.setZdxsrs(studentNum);
        zDXSJS.setJsxscc(2);
        float gzl = zDXSJSService.getGzl(competition, contestLevel);
        gzl = gzl * studentNum;
        System.out.println(gzl);
        zDXSJS.setGzl(gzl);
        // 添加到数据库
        zDXSJSService.addZDXSJS(zDXSJS);
    }

    @NeedLogin
    @RequestMapping("/saveMasterCount")
    @ResponseBody
    public void save(Integer slwNum, Integer xlwNum, Users users) {
        ZDSSLW zDSSLW = new ZDSSLW();
        String gh = users.getGh();
        zDSSLW.setGh(gh);
        zDSSLW.setNd(DateUtils.getCurrentYear());
        zDSSLW.setSylwrs(slwNum);
        zDSSLW.setXylwrs(xlwNum);
        //float gzl = slwNum * 50 + xlwNum * 10;
        float gzl = GetWorkLoad.getGraduatePaper(slwNum, xlwNum);
        zDSSLW.setGzl(gzl);
        // 判断数据库中是否有记录
        int count = zDSSLWService.isOnlyForOneYear(users.getGh(), DateUtils.getCurrentYear());
        System.out.println(count);
        if(count == 0) {
            // 添加
            zDSSLWService.addZDSSLW(zDSSLW);
        }else {
            // 更新
            zDSSLWService.updateZDSSLW(zDSSLW);
        }
    }

    @NeedLogin
    @RequestMapping("/getMasterLwGzl")
    @ResponseBody
    public Float getLwGzl(Users users) {
        return zDSSLWService.getAllMasterLwGzl(users.getGh(), DateUtils.getCurrentYear());
    }

    @NeedLogin
    @RequestMapping("/getMasterStudentCompetitionGzl")
    @ResponseBody
    public Float getMasterStudentCompetitionGzl(Users users) {
        return zDXSJSService.getAllGzl2(users.getGh(), DateUtils.getCurrentYear());
    }

    @NeedLogin
    @RequestMapping("/getMasterAllGzl")
    @ResponseBody
    public Float getAllGzl(Users users) {
        Float gul2 = zDXSJSService.getAllGzl2(users.getGh(), DateUtils.getCurrentYear());
        Float lwgzl = zDSSLWService.getAllMasterLwGzl(users.getGh(), DateUtils.getCurrentYear());
        if(lwgzl != null && gul2 != null) {
            return gul2+lwgzl;
        }else if(lwgzl != null){
            return lwgzl;
        }else if(gul2 != null) {
            return gul2;
        }else {
            return 0f;
        }
    }

    /**
     * 删除研究生竞赛
     */
    @NeedLogin
    @RequestMapping(value = "/deleteGraduate")
    public String deleteGraduate(@ModelAttribute(value = "id") Integer id, Users users) {
        System.out.println(id);
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            // 未提交，可以删除
            zDXSJSService.remove(id);
        }
        return "redirect:masterKnow";
    }
}
