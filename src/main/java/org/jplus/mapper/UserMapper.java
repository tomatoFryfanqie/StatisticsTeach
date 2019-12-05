package org.jplus.mapper;

import org.apache.ibatis.annotations.*;
import org.jplus.pojo.Users;
import org.jplus.pojo.queryVo.UserVo;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserMapper {

    @Select("SELECT * FROM users WHERE gh=#{gh}")
    Users getById(@Param("gh") String gh);

    @Update("update users set upassword=#{upassword} where gh=#{gh}")
    void update(@Param("upassword")String upassword,@Param("gh") String gh);

    @Select("SELECT COUNT(*) FROM users WHERE gh=#{gh}")
    Integer checkGhIsRepeat(@Param("gh") String gh);

    void addUser(Users user);

    @Select("SELECT * FROM users WHERE yxbm=#{yxbm}")
    List<UserVo> getAllUsers(@Param("yxbm") Integer yxbm);

    @Delete("DELETE FROM users WHERE gh=#{gh}")
    void deleteUser(@Param("gh") String gh);
    @Select("SELECT * FROM users WHERE actor=#{actor} || actor=2")
    List<UserVo> getAllOfficeUsers(@Param("actor")  Integer actor);
    @Insert("INSERT INTO users VALUES(#{gh}, #{yxbm}, #{uname}, #{upassword}, #{actor})")
    void addOfficeUser(Users user);
    @Select("SELECT yxmc FROM yxbm WHERE yxbm=#{yxbm}")
    String findYxmcByYxbm(@Param("yxbm") int yxbm);
    @Select("SELECT yxbm FROM users WHERE gh=#{gh}")
    Integer findYxmcByActor(@Param("gh") String gh);
}
