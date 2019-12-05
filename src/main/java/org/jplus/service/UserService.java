package org.jplus.service;

import org.jplus.dto.LoginVo;
import org.jplus.pojo.Users;
import org.jplus.pojo.queryVo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService {
    Users login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    boolean updatePassword(String gh,String oldPassword,String password,HttpServletRequest request);

    Integer checkGhIsRepeat(String gh);

    void addUser(Users user);

    List<UserVo> getAllUsers(Integer yxbm);

    void deleteUser(String gh);

    List<UserVo> getAllOfficeUsers(Integer actor);

    void addOfficeUser(Users user);

    String findYxmcByYxbm(int yxbm);

    Integer findYxmcByActor(String gh);
}
