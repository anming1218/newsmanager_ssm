package com.ming.ssm.dao;
import com.ming.ssm.domain.News;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 新闻的持久层接口
 *@author: ming
 *@create: 2020-07-30 20:18
 */
@Repository
public interface NewsDao {

    /**
     * 查询所有新闻
     * @return
     * @throws Exception
     */
    @Select("select nid,topicname,title,author,summary,content,creattime,creatby,modifytime,modifyby,frequency from NEWS n left outer join TOPIC t on n.TID = t.TID")
    @Results({
            @Result(id = true, property = "nid", column = "nid"),
            @Result(property = "topic.topicname", column = "topic.topicname"),
            @Result(property = "title",column = "title"),
            @Result(property = "author", column = "author"),
            @Result(property = "summary",column = "summary"),
            @Result(property = "content", column = "content"),
            @Result(property = "creattime",column = "creattime"),
            @Result(property = "creatby", column = "creatby"),
            @Result(property = "modifytime",column = "modifytime"),
            @Result(property = "modifyby", column = "modifyby"),
            @Result(property = "frequency",column = "frequency"),
    })
    List<News> findAll() throws Exception;

}
