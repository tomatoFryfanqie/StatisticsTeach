package org.jplus.controller;

import org.jplus.pojo.Users;
import org.jplus.service.OfficecollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:审核本院工作量1控制层
 * @author:zmj
 * @date 2019/11/1615:05
 */
@Controller
public class OfficecollegeController {

   @Autowired
   OfficecollegeService officecollegeService;

    @RequestMapping("/officecollege")
    public String officecollege(Users user, Model model){
        model.addAttribute("yxmc",officecollegeService.getYxmc(user.getGh()));
        model.addAttribute("Checkgzls",officecollegeService.getCheckgzlInf(user.getGh()));
        return "/officecollege";
    }
}
