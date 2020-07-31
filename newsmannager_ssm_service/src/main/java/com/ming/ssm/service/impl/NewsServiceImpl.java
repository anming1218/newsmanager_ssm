package com.ming.ssm.service.impl;
import com.github.pagehelper.PageHelper;
import com.ming.ssm.dao.NewsDao;
import com.ming.ssm.domain.News;
import com.ming.ssm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 新闻的业务层实现类
 *@author: ming
 *@create: 2020-07-30 21:02
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    /**
     * 查询所有新闻
     * @return
     * @throws Exception
     */
    @Override
    public List<News> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return newsDao.findAll();
    }
}
