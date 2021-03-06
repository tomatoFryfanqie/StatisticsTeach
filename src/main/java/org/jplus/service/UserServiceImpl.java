package org.jplus.service;
import org.jplus.dto.LoginVo;
import org.jplus.mapper.UserMapper;
import org.jplus.pojo.Users;
import org.jplus.pojo.queryVo.UserVo;
import org.jplus.utils.MD5Util;
import org.jplus.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    public static final String COOK_NAME_TOKEN="jplus_user";


    @Autowired
    private UserMapper userMapper;

    @Override
    public void deleteUser(String gh) {
        userMapper.deleteUser(gh);
    }

    @Override
    public List<UserVo> getAllUsers(Integer yxbm) {
        return userMapper.getAllUsers(yxbm);
    }

    @Override
    public void addOfficeUser(Users user) {
        userMapper.addOfficeUser(user);
    }

    @Override
    public Integer findYxmcByActor(String gh) {
        return userMapper.findYxmcByActor(gh);
    }

    @Override
    public String findYxmcByYxbm(int yxbm) {
        return userMapper.findYxmcByYxbm(yxbm);
    }

    @Override
    public List<UserVo> getAllOfficeUsers(Integer actor) {
        return userMapper.getAllOfficeUsers(actor);
    }

    @Override
    public Users login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        if (loginVo == null){
            //前面有了参数校验,这里还是校验下吧
            return  null;
        }
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
        return user;
    }

    @Override
    public boolean updatePassword(String gh,String oldPassword,String newPassword,HttpServletRequest request) {
        Users user= userMapper.getById(gh);
        if (user==null){
            return false;
        }
        String formPassword=MD5Util.md5(oldPassword);
        if (!formPassword.equals(user.getUpassword())){
            return false;
        }
        String pass=MD5Util.md5(newPassword);
        //更新密码
        userMapper.update(pass,gh);
        //删除session
        String token= getCookieValue(request, COOK_NAME_TOKEN);
        request.getSession().removeAttribute(token);
        return true;
    }

    @Override
    public void addUser(Users user) {
        userMapper.addUser(user);
    }

    @Override
    public Integer checkGhIsRepeat(String gh) {
        return userMapper.checkGhIsRepeat(gh);
    }

    private void addCookies(HttpServletResponse response,String token) {
        Cookie cookie = new Cookie(COOK_NAME_TOKEN, token);
        //设置Cookie过期时间 12h
        cookie.setMaxAge(3600*12);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    //懒得抽了,直接拿过来, 能用就行.jpg
    private String getCookieValue(HttpServletRequest request, String cookNameToken) {
        Cookie[] cookies=request.getCookies();
        if (cookies==null || cookies.length<=0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookNameToken.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }
}
