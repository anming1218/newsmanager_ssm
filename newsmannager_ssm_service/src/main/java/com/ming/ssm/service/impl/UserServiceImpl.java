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
     * 查询所有用户
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
}
