package org.jplus.controller;

import org.jplus.dto.LoginVo;
import org.jplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author imlgw.top
 * @date 2019/10/31 17:13
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/do_login")
    public String login(HttpServletResponse response,HttpServletRequest request, @Validated @ModelAttribute(value =
            "loginVo")
            LoginVo loginVo, BindingResult bindingResult, Model model) throws IOException {
        if (bindingResult.hasErrors()){
            model.addAttribute("error","账号或密码不能为空！！！");
            return "login";
        }
        boolean islogin=userService.login(loginVo,request,response);
        if (!islogin){
            model.addAttribute("error","账号密码错误");
            return "login";
        }
        return "redirect:/basicinformation";
    }
}
