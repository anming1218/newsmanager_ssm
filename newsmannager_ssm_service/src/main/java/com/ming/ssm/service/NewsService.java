package com.ming.ssm.service;
import com.ming.ssm.domain.News;

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
    List<News> findAll(int page,int size) throws Exception;

}
