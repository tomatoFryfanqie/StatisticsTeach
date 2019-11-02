package org.jplus.interceptor;

import org.jplus.pojo.Users;
import org.jplus.service.UserServiceImpl;
import org.jplus.utils.UserContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author imlgw.top
 * @date 2019/10/31 18:56
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod hm=(HandlerMethod) handler;
        Users users = getUser(request, response);
        //有的页面不需要登陆但是需要用户信息，所以需要先存进去
        UserContext.setUser(users);
        //获取方法上的注解
        NeedLogin needLogin = hm.getMethodAnnotation(NeedLogin.class);
        if(needLogin==null || ! needLogin.needLogin()){
            //没有注解或者注解为false,就直接放过
            return true;
        }
        //有注解，没登陆
        if(users==null){
            //跳转到登陆页
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    private Users getUser(HttpServletRequest request, HttpServletResponse response) {
        //拿参数中的token(有的设备不支持cookie,会重写URL将cookie放在参数中)
        String paramToken = request.getParameter(UserServiceImpl.COOK_NAME_TOKEN);
        //拿cookie中的token
        String cookieToken = getCookieValue(request, UserServiceImpl.COOK_NAME_TOKEN);
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            //没登陆, cookie为空
            return null;
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        //获取服务端session中的user信息,默认应该是30分钟
        Users user= (Users) request.getSession().getAttribute(token);
        return user;
    }

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


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //结束后删除User
        UserContext.removeUser();
    }
}
