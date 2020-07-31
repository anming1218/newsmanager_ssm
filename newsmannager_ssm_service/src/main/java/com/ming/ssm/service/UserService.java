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
     * 查询所有用户
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<User> findAll(int page,int size) throws Exception;

    /**
     * 增加用户
     * @param user
     * @throws Exception
     */
    void saveUser(User user) throws Exception;

}
