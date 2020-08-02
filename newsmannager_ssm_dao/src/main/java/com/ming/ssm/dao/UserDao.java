package com.ming.ssm.dao;
import com.ming.ssm.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 用户的持久层接口
 *@author: ming
 *@create: 2020-07-30 12:58
 */
@Repository
public interface UserDao {


    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    @Results({
            @Result(id = true, property = "userid", column = "userid"),
            @Result(property = "username", column = "username"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "age", column = "age"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password")
    })
    List<User> findAll() throws Exception;


    /**
     * 增加用户
     * @param user
     * @throws Exception
     */
    @Insert("INSERT INTO USERS(username, gender, age, email, password) VALUES (#{username},#{gender},#{age},#{email},#{password})")
    void saveUser(User user) throws Exception;

    /**
     * 根据id查找用户
     * @param userid
     * @return
     */
    @Select("select * from users where userid=#{userid}")
    User findUserById(String userid);

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    @Update("update users set gender=#{gender},age=#{age},email=#{email},password=#{password} where userid=#{userid}")
    void updateUser(User user) throws Exception;

    /**
     * 登录方法，确认存在用户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from USERS where username = #{username} and password = #{password}")
    User login(@Param("username") String username,@Param("password") String password);

    /**
     * 根据id删除用户
     * @param userid
     * @throws Exception
     */
    @Delete("delete users where userid = #{userid}")
    void deleteUser(String userid) throws Exception;

    /**
     * 根据条件模糊查询
     * @param username
     * @param age
     * @param email
     * @return
     */
    @Select("select * from USERS where 1=1 and username like '%#{username}%' and age like '%#{age}%' and email like '#{email}';")
    List<User> findLikeUser(@Param("username")String username,@Param("age")int age,@Param("email")String email);

}
