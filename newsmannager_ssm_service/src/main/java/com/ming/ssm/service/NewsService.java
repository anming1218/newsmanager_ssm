package com.ming.ssm.service;
import com.ming.ssm.domain.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 新闻的业务层接口
 *@author: ming
 *@create: 2020-07-30 21:01
 */
public interface NewsService {

    /**
     * 查询所有新闻
     * @return
     * @throws Exception
     */
    List<News> findAll(int page, int size) throws Exception;

    /**
     * 增加新闻
     * @param news
     * @throws Exception
     */
    void saveNews(News news) throws Exception;

    /**
     * 根据id查找新闻
     * @param nid
     * @return
     * @throws Exception
     */
    News findNewsById(String nid) throws Exception;

    /**
     * 更新新闻
     * @param news
     * @throws Exception
     */
    void updateNews(News news) throws Exception;

    /**
     * 根据id删除新闻
     * @param nid
     * @throws Exception
     */
    void deleteNews(String nid) throws Exception;

}
