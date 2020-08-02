package com.ming.ssm.service;
import com.ming.ssm.domain.News;
import org.apache.ibatis.annotations.*;

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

    /**
     * 删除选中的新闻
     * @param nids
     * @throws Exception
     */
    void deleteSelectedNews(String[] nids) throws Exception;

    /**
     * 查找全部新闻,并显示在主页(只查询nid和title)
     * @return
     * @throws Exception
     */
    List<News> findHomeNews(int page,int size) throws Exception;

    /**
     * 分类查找新闻
     * @param tid
     * @return
     * @throws Exception
     */
    List<News> findKindsNews(String tid) throws Exception;

    /**
     * 查找实时新闻（新闻直播间）
     * @return
     * @throws Exception
     */
    List<News> findRealNews() throws Exception;

    /**
     * 查找实时热搜新闻，依照查看次数
     * @return
     * @throws Exception
     */
    List<News> findHotNews() throws Exception;


}
