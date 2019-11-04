package org.jplus.interceptor;

import java.lang.annotation.*;

/**
 * @author imlgw.top
 * @date 2019/10/31 18:59
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLogin {
    //默认需要登录
    boolean needLogin() default true;
}