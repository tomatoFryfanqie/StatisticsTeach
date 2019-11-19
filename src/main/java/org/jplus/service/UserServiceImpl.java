package org.jplus.service;

import org.jplus.dto.LoginVo;
import org.jplus.mapper.UserMapper;
import org.jplus.pojo.Users;
import org.jplus.utils.MD5Util;
import org.jplus.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author imlgw.top
 * @date 2019/10/31 17:32
 */
@Service
public class UserServiceImpl implements UserService{

    public static final String COOK_NAME_TOKEN="jplus_user";

    @Autowired
    private UserMapper userMapper;


    @Override
    public Users login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        if (loginVo == null){
            //前面有了参数校验,这里还是校验下吧
            return  null;
        }
        //System.out.println(loginVo);
        Users user= userMapper.getById(loginVo.getGh());
        if (user==null){
            return null;
        }
        String loginPassword=MD5Util.md5(loginVo.getPassword());
        if (!loginPassword.equals(user.getUpassword())){
            return null;
        }
        String token=UUIDUtil.getUuid();
        //将User存到服务端(Tomcat)session中
        //扩展的话就只需要将这个存到Redis等中间件中就行了
        request.getSession().setAttribute(token,user);
        //添加token到cookie中
        addCookies(response,token);
        System.out.println(user);
        return user;
    }

    private void addCookies(HttpServletResponse response,String token) {
        Cookie cookie = new Cookie(COOK_NAME_TOKEN, token);
        //设置Cookie过期时间 12h
        cookie.setMaxAge(3600*12);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}
