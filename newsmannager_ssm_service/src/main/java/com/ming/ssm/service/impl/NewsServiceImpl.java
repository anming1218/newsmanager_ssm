package com.ming.ssm.service.impl;
import com.github.pagehelper.PageHelper;
import com.ming.ssm.dao.NewsDao;
import com.ming.ssm.domain.News;
import com.ming.ssm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    /**
     * 增加新闻
     * @param news
     * @throws Exception
     */
    @Override
    public void saveNews(News news) throws Exception {
        news.setCreattime(new Date());
        newsDao.saveNews(news);
    }

    /**
     * 根据id查找新闻
     * @param nid
     * @return
     * @throws Exception
     */
    @Override
    public News findNewsById(String nid) throws Exception {
        return newsDao.findNewsById(nid);
    }

    /**
     * 更新新闻
     * @param news
     * @throws Exception
     */
    @Override
    public void updateNews(News news) throws Exception {
        newsDao.updateNews(news);
    }

    /**
     * 根据id删除新闻
     * @param nid
     * @throws Exception
     */
    @Override
    public void deleteNews(String nid) throws Exception {
        newsDao.deleteNews(nid);
    }

    /**
     * 删除选中的新闻
     * @param nids
     * @throws Exception
     */
    @Override
    public void deleteSelectedNews(String[] nids) throws Exception {
        if (nids != null && nids.length > 0) {
            for (String nid : nids) {
                newsDao.deleteNews(nid);
            }
        }
    }

    /**
     * 查找全部新闻,并显示在主页(只查询nid和title)
     * @return
     * @throws Exception
     */
    @Override
    public List<News> findHomeNews(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return newsDao.findHomeNews();
    }

    /**
     * 分类查找新闻
     * @param tid
     * @return
     * @throws Exception
     */
    @Override
    public List<News> findKindsNews(String tid) throws Exception {
        return newsDao.findKindsNews(tid);
    }

    /**
     * 查找实时新闻（新闻直播间）
     * @return
     * @throws Exception
     */
    @Override
    public List<News> findRealNews() throws Exception {
        return newsDao.findRealNews();
    }

    /**
     * 查找实时热搜新闻，依照查看次数
     * @return
     * @throws Exception
     */
    @Override
    public List<News> findHotNews() throws Exception {
        return newsDao.findHotNews();
    }


}
