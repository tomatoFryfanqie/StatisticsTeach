package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.service.UserService;
import org.jplus.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wb
 * @date 2019/11/16 - 17:51
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
