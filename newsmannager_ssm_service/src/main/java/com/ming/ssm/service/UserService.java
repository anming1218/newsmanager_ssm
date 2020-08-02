package com.ming.ssm.service;


import com.ming.ssm.domain.User;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 用户的业务接口
 *@author: ming
 *@create: 2020-07-30 12:56
 */

public interface UserService {


    /**
     * 查询所有用户(分页)
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<User> findAll(int page, int size) throws Exception;


    /**
     * 增加用户
     * @param user
     * @throws Exception
     */
    void saveUser(User user) throws Exception;

    /**
     * 根据id查询用户信息
     * @param userid
     * @return
     * @throws Exception
     */
    User findUserById(String userid) throws Exception;

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;

    /**
     * 登录方法，确认存在用户
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 根据id删除用户
     * @param userid
     * @throws Exception
     */
    void deleteUser(String userid) throws Exception;

    /**
     * 删除选中的用户
     * @param userids
     * @throws Exception
     */
    void deleteSelectedUser(String[] userids) throws Exception;

    /**
     * 根据条件模糊查询
     * @param username
     * @param age
     * @param email
     * @return
     */
    List<User> findLikeUser(int page, int size, String username, int age, String email);


}
