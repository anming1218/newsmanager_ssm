package com.ming.ssm.service.impl;
import com.github.pagehelper.PageHelper;
import com.ming.ssm.dao.TopicDao;
import com.ming.ssm.domain.Topic;
import com.ming.ssm.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 主题的业务层实现
 *@author: ming
 *@create: 2020-07-30 16:56
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;


    /**
     * 查询所有主题
     * @return
     * @throws Exception
     */
    @Override
    public List<Topic> findAll(int page, int size) throws Exception {
        //pageNum是页码值，pageS ize是每页显示条数
        PageHelper.startPage(page,size);
        return topicDao.findAll();
    }
}
