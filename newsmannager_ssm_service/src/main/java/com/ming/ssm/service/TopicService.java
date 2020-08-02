package com.ming.ssm.service;
import com.ming.ssm.domain.Topic;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 主题的业务层接口
 *@author: ming
 *@create: 2020-07-30 16:55
 */
public interface TopicService {

    /**
     * 查询所有主题(分页)
     * @return
     * @throws Exception
     */
    List<Topic> findAll(int page, int size) throws Exception;

    /**
     * 查询所有主题(不分页)
     * @return
     * @throws Exception
     */
    List<Topic> findAll() throws Exception;

    /**
     * 保存主题
     * @param topic
     * @throws Exception
     */
    void saveTopic(Topic topic) throws Exception;

    /**
     * 修改主题
     * @param topic
     * @throws Exception
     */
    void updateTopic(Topic topic) throws Exception;

    /**
     * 根据id查找主题
     * @param tid
     * @return
     * @throws Exception
     */
    Topic findUserById(String tid) throws Exception;

    /**
     * 根据id删除主题
     * @param tid
     * @throws Exception
     */
    void deleteTopic(String tid) throws Exception;

    /**
     * 删除选中的主题
     * @param tids
     * @throws Exception
     */
    void deleteSelectedTopic(String[] tids) throws Exception;


}
