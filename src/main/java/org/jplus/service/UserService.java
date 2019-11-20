package org.jplus.service;

import org.jplus.dto.LoginVo;
import org.jplus.pojo.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/10/31 17:32
 */
public interface UserService {
    Users login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    boolean updatePassword(String gh,String oldPassword,String password,HttpServletRequest request);

    Integer checkGhIsRepeat(String gh);

    void addUser(Users user);

    List<Users> getAllUsers(Integer yxbm);

    void deleteUser(String gh);
}
