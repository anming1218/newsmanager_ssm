package com.ming.ssm.dao;
import com.ming.ssm.domain.News;
import com.ming.ssm.domain.Topic;
import org.apache.ibatis.annotations.*;
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
    @Select("select * from news order by creattime desc")
    @Results({
            @Result(id = true, property = "nid", column = "nid"),
            @Result(property = "topic", column = "tid", javaType = Topic.class, one = @One(select = "com.ming.ssm.dao.TopicDao.findTopicById")),
            @Result(property = "title", column = "title"),
            @Result(property = "author", column = "author"),
            @Result(property = "summary", column = "summary"),
            @Result(property = "content", column = "content"),
            @Result(property = "creattime", column = "creattime"),
            @Result(property = "creatby", column = "creatby"),
            @Result(property = "modifytime", column = "modifytime"),
            @Result(property = "modifyby", column = "modifyby"),
            @Result(property = "frequency", column = "frequency"),
    })
    List<News> findAll() throws Exception;


    /**
     * 增加新闻
     * @param news
     * @throws Exception
     */
    @Insert("INSERT INTO NEWS(TID, title, author, summary, content, creattime, creatby,frequency) " +
            "VALUES (#{topic.tid},#{title},#{author},#{summary},#{content},#{creattime},#{creatby},#{frequency})")
    void saveNews(News news) throws Exception;

    /**
     * 根据id查找新闻
     * @param nid
     * @return
     * @throws Exception
     */
    @Select("select * from news where nid=#{nid}")
    @Results({
            @Result(id = true, property = "nid", column = "nid"),
            @Result(property = "topic", column = "tid", javaType = Topic.class, one = @One(select = "com.ming.ssm.dao.TopicDao.findTopicById")),
            @Result(property = "title", column = "title"),
            @Result(property = "author", column = "author"),
            @Result(property = "summary", column = "summary"),
            @Result(property = "content", column = "content"),
            @Result(property = "creattime", column = "creattime"),
            @Result(property = "creatby", column = "creatby"),
            @Result(property = "modifytime", column = "modifytime"),
            @Result(property = "modifyby", column = "modifyby"),
            @Result(property = "frequency", column = "frequency"),
    })
    News findNewsById(String nid) throws Exception;

    /**
     * 更新新闻
     * @param news
     * @throws Exception
     */
    @Update("update news set TID=#{topic.tid},title=#{title},author=#{author},summary=#{summary},modifyby=#{modifyby} where nid=#{nid}")
    void updateNews(News news) throws Exception;

    /**
     * 根据id删除新闻
     * @param nid
     * @throws Exception
     */
    @Delete("delete news where nid =#{nid}")
    void deleteNews(String nid) throws Exception;

    /**
     * 查找全部新闻,并显示在主页(只查询nid和title)
     * @return
     * @throws Exception
     */
    @Select("select nid,title,tid,summary from news")
    @Results({
            @Result(id = true, property = "nid", column = "nid"),
            @Result(property = "topic", column = "tid", javaType = Topic.class, one = @One(select = "com.ming.ssm.dao.TopicDao.findTopicById")),
            @Result(property = "title", column = "title"),
            @Result(property = "summary", column = "summary"),
    })
    List<News> findHomeNews() throws Exception;

    /**
     * 分类查找新闻
     * @param tid
     * @return
     * @throws Exception
     */
    @Select("select tid,title from(\n" +
            "select tid,title from news where tid = #{tid} order by creattime desc)\n" +
            "where rownum <= 5")
    List<News> findKindsNews(String tid) throws Exception;

    /**
     * 查找实时新闻（新闻直播间）
     * @return
     * @throws Exception
     */
    @Select("select tid,title from(\n" +
            "select tid,title from news order by creattime desc)\n" +
            "where rownum <= 15")
    List<News> findRealNews() throws Exception;

    /**
     * 查找实时热搜新闻，依照查看次数
     * @return
     * @throws Exception
     */
    @Select("select tid,title from(\n" +
            "select tid,title from news order by frequency desc)\n" +
            "where rownum <= 10")
    List<News> findHotNews() throws Exception;

}
