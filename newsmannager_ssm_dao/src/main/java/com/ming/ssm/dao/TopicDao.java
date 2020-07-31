package com.ming.ssm.dao;
import com.ming.ssm.domain.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 主题的持久层接口
 *@author: ming
 *@create: 2020-07-30 16:49
 */
@Repository
public interface TopicDao {


    /**
     * 查询所有主题
     * @return
     * @throws Exception
     */
    @Select("select * from topic")
    @Results({
            @Result(id = true, property = "tid", column = "tid"),
            @Result(property = "topicname", column = "topicname")
    })
    List<Topic> findAll() throws Exception;

    /**
     * 保存主题
     * @param topic
     * @throws Exception
     */
    @Insert("INSERT INTO TOPIC(topicname) VALUES (#{topicname})")
    void saveTopic(Topic topic) throws Exception;

    /**
     * 根据id查找主题
     * @param tid
     * @return
     * @throws Exception
     */
    @Select("select * from topic where tid=#{tid}")
    Topic findTopicById(String tid) throws Exception;

}
