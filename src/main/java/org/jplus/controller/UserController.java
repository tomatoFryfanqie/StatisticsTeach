package org.jplus.controller;

import org.jplus.dto.LoginVo;
import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.service.UserService;
import org.jplus.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wb
 * @date 2019/11/16 - 17:51
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/do_login")
    public String login(HttpServletResponse response, HttpServletRequest request, @Validated @ModelAttribute(value =
            "loginVo")
            LoginVo loginVo, BindingResult bindingResult, Model model) throws IOException {
        if (bindingResult.hasErrors()){
            model.addAttribute("error","账号或密码不能为空！！！");
            return "login";
        }
        Users user=userService.login(loginVo,request,response);
        if (user==null){
            model.addAttribute("error","账号密码错误");
            return "login";
        }
        if (user.getActor()==3){
            return "redirect:/departmentmaintenance";
        }
        if (user.getActor()==2){
            return "redirect:/departmentmaintenance";
        }
        return "redirect:/basicinformation";
    }

    @RequestMapping("/updatepassword")
    public String updatePassword(Users user,String oldPassword,String newPassword,Model model,HttpServletRequest request){
        System.out.println(oldPassword+":"+newPassword);
        boolean isOK = userService.updatePassword(user.getGh(), oldPassword, newPassword,request);
        if (!isOK){
            model.addAttribute("error","旧密码不正确！！！");
            return "redirect:/basicinformation";
        }
        return "redirect:/";
    }

    @RequestMapping("/user")
    @NeedLogin
    public String hello(Model model, Users users) {
        List<Users> userList = userService.getAllUsers(users.getYxbm());
        model.addAttribute("userList", userList);
        return "officemaintenance";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    @NeedLogin
    public String addUser(int department, String gh, String name, int type) {
        Users user = new Users();
        user.setYxbm(department);
        user.setGh(gh);
        user.setUname(name);
        user.setActor(type);
        user.setUpassword(MD5Util.md5("123456"));
        // 判断主键工号是否重复
        int flag = userService.checkGhIsRepeat(gh);
        if(flag == 0) {
            // 没有重复，可以添加
            userService.addUser(user);
        }else {
            return "该工号重复，请重新添加";
        }
        return "添加成功";
    }

    /**
     * 删除用户
     */
    @NeedLogin
    @RequestMapping(value = "/deleteUser")
    public String delete(@ModelAttribute(value = "gh") String gh) {
        System.out.println(gh);
        userService.deleteUser(gh);
        return "redirect:user";
    }
}
