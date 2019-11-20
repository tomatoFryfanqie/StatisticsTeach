package org.jplus.controller;

import org.jplus.pojo.Users;
import org.jplus.service.TjztService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author imlgw.top
 * @date 2019/11/19 16:52
 */
@Controller
public class TjController {

    @Autowired
    private TjztService tjztService;

    @RequestMapping("/submit")
    public String submit(Users users){
        tjztService.updateTjzt(users.getGh());
        return "redirect:basicinformation";
    }
}
