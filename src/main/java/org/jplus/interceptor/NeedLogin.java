package org.jplus.interceptor;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLogin {
    //默认需要登录
    boolean needLogin() default true;
}