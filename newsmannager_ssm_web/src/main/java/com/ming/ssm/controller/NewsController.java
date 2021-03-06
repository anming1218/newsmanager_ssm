package com.ming.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.News;
import com.ming.ssm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 新闻的控制类
 *@author: ming
 *@create: 2020-07-30 21:05
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 查询所有新闻
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "8") int size) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<News> list = newsService.findAll(page, size);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pb", pageInfo);
        mv.setViewName("news_list");
        return mv;
    }

    /**
     * 增加新闻
     * @param news
     * @return
     */
    @RequestMapping("/saveTopic.do")
    public String saveNews(News news) throws Exception {
        newsService.saveNews(news);
        return "redirect:findAll.do";
    }

    /**
     * 修改新闻
     * @param news
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateNews.do")
    public String updateNews(News news) throws Exception {

        newsService.updateNews(news);
        return "redirect:findAll.do";

    }

    /**
     * 根据id删除新闻
     * @param nid
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteNews.do")
    public String deleteNews(String nid)throws Exception{
        newsService.deleteNews(nid);
        return "redirect:findAll.do";
    }

    /**
     * 删除选中的用户
     * @param request
     * @return
     */
    @RequestMapping("/deleteSelectNews.do")
    public String deleteSelectNews(HttpServletRequest request) throws Exception {

        String[] nids = request.getParameterValues("nid");

        newsService.deleteSelectedNews(nids);

        return "forward:findAll.do";
    }


}
