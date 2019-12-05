package org.jplus.utils;
import org.jplus.pojo.Users;

public class UserContext {

    //这个类用于保存用户信息的上下文,在同一个请求线程中都可以拿到User对象
    private static  ThreadLocal<Users> userHolder =new ThreadLocal<>();

    public static void setUser(Users user){
        userHolder.set(user);
    }

    public static Users getUser(){
        return userHolder.get();
    }

    public static void removeUser(){
        userHolder.remove();
    }
}
