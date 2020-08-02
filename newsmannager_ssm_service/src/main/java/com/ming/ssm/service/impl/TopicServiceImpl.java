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
     * 查询所有主题（分页）
     * @return
     * @throws Exception
     */
    @Override
    public List<Topic> findAll(int page, int size) throws Exception {
        //pageNum是页码值，pageS ize是每页显示条数
        PageHelper.startPage(page, size);
        return topicDao.findAll();
    }

    /**
     * 查询所有主题(不分页)
     * @return
     * @throws Exception
     */
    @Override
    public List<Topic> findAll() throws Exception {
        return topicDao.findAll();
    }

    /**
     * 保存主题
     * @param topic
     * @throws Exception
     */
    @Override
    public void saveTopic(Topic topic) throws Exception {
        topicDao.saveTopic(topic);
    }

    /**
     * 修改主题
     * @param topic
     * @throws Exception
     */
    @Override
    public void updateTopic(Topic topic) throws Exception {
        topicDao.updateTopic(topic);
    }

    /**
     * 根据id查找主题
     * @param tid
     * @return
     * @throws Exception
     */
    @Override
    public Topic findUserById(String tid) throws Exception {
        return topicDao.findTopicById(tid);
    }

    /**
     * 根据id删除主题
     * @param tid
     * @throws Exception
     */
    @Override
    public void deleteTopic(String tid) throws Exception {
        topicDao.deleteTopic(tid);
    }

    /**
     * 删除选中的主题
     * @param tids
     * @throws Exception
     */
    @Override
    public void deleteSelectedTopic(String[] tids) throws Exception {
        if (tids != null && tids.length > 0) {
            for (String tid : tids) {
                topicDao.deleteTopic(tid);
            }
        }
    }
}
