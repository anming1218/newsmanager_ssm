package com.ming.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ming.ssm.dao.UserDao;
import com.ming.ssm.domain.User;
import com.ming.ssm.service.UserService;
import com.ming.ssm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 用户的业务实现
 *@author: ming
 *@create: 2020-07-30 13:03
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 查询所有用户(分页)
     * @return
     */
    @Override
    public List<User> findAll(int page, int size) throws Exception {
        //pageNum是页码值，pageS ize是每页显示条数
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }


    /**
     * 增加用户
     * @param user
     * @throws Exception
     */
    @Override
    public void saveUser(User user) throws Exception {

        user.setPassword(MD5Utils.md5(user.getPassword()));
        userDao.saveUser(user);
    }

    /**
     * 根据id查询用户信息
     * @param userid
     * @return
     * @throws Exception
     */
    @Override
    public User findUserById(String userid) throws Exception {
        return userDao.findUserById(userid);
    }

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    /**
     * 登录方法，确认存在用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {

        password = MD5Utils.md5(password);

        return userDao.login(username, password);

    }

    /**
     * 根据id删除用户
     * @param userid
     * @throws Exception
     */
    @Override
    public void deleteUser(String userid) throws Exception {
        userDao.deleteUser(userid);
    }

    /**
     * 根据条件模糊查询
     * @param username
     * @param age
     * @param email
     * @return
     */
    @Override
    public List<User> findLikeUser(int page, int size, String username, int age, String email) {
        PageHelper.startPage(page, size);
        return userDao.findLikeUser(username, age, email);
    }


}
