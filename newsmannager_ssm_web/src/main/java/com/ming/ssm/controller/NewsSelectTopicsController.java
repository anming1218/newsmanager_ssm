package com.ming.ssm.controller;
import com.ming.ssm.domain.News;
import com.ming.ssm.domain.Topic;
import com.ming.ssm.service.NewsService;
import com.ming.ssm.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 新闻与主题相关联的控制类
 *@author: ming
 *@create: 2020-07-31 10:26
 */
@Controller
@RequestMapping("/newsAndTopics")
public class NewsSelectTopicsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private TopicService topicService;

    /**
     * 增加新闻时可以选择主题
     * @return
     * @throws Exception
     */
    @RequestMapping("/newsAddWithTopic.do")
    public ModelAndView newsAddWithTopic() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Topic> topicList = topicService.findAll();
        mv.addObject("topics", topicList);
        mv.setViewName("news_add");

        return mv;
    }

    /**
     * 回显新闻
     * @param nid
     * @return
     * @throws Exception
     */
    @RequestMapping("/echoNews.do")
    public ModelAndView echoNews(@RequestParam("nid") String nid) throws Exception {

        ModelAndView mv = new ModelAndView();
        News news = newsService.findNewsById(nid);
        mv.addObject("news", news);


        List<Topic> topicList = topicService.findAll();
        mv.addObject("topics", topicList);
        mv.setViewName("news_update");

        return mv;
    }

}
