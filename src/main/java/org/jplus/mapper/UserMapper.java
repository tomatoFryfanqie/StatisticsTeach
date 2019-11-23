package org.jplus.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.Users;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/10/31 17:25
 */
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
    List<Users> getAllUsers(@Param("yxbm") Integer yxbm);

    @Delete("DELETE FROM users WHERE gh=#{gh}")
    void deleteUser(@Param("gh") String gh);
}
