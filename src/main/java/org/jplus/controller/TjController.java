package org.jplus.controller;

import org.jplus.pojo.Tjzt.Tjzt;
import org.jplus.pojo.Users;
import org.jplus.service.TjztService;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class TjController {

    @Autowired
    private TjztService tjztService;

    @RequestMapping("/submit")
    public String submit(Users users){

        java.sql.Timestamp date = new java.sql.Timestamp(new Date().getTime());
        tjztService.updateTjzt(users.getGh(),date);
        tjztService.insertTJB(GetYear.getYears(),users.getGh());
        return "redirect:basicinformation";
    }
}
