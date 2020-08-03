package com.ming.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.News;
import com.ming.ssm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 新闻的主页控制
 *@author: ming
 *@create: 2020-08-02 09:51
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/homeNews.do")
    public ModelAndView findNewsToHome(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "10") int size) throws Exception {

        ModelAndView mv = new ModelAndView();

        /*
         *  查找全部新闻,并显示在主页(只查询nid和title)
         */
        List<News> homeNews = newsService.findHomeNews(page, size);
        PageInfo pageInfo = new PageInfo(homeNews);
        mv.addObject("pb", pageInfo);


        /*
         *   分类查找新闻
         */
        String local = "5F8CA04B6A8B4219B7939091CAC0D659";
        String forien = "C114086D506C48248E63569B0E0FA345";
        String money = "CE7E35C77D9E4E14981E0EFFC00D7AFF";

        List<News> localNews = newsService.findKindsNews(local);
        List<News> forienNews = newsService.findKindsNews(forien);
        List<News> moneyNews = newsService.findKindsNews(money);

        mv.addObject("localnewss", localNews);
        mv.addObject("foriennewss", forienNews);
        mv.addObject("moneynewss", moneyNews);

        /*
         *  查找实时新闻（新闻直播间）
         */
        List<News> realNews = newsService.findRealNews();
        mv.addObject("realtimenews", realNews);

        /*
         *   查找实时热搜新闻，依照查看次数
         */
        List<News> hotNews = newsService.findHotNews();
        mv.addObject("hotnews", homeNews);

        mv.setViewName("home");
        return mv;
    }

    /**
     * 新闻详情
     * @param nid
     * @return
     */
    @RequestMapping("/readNews.do")
    public ModelAndView readNews(@RequestParam("nid") String nid) throws Exception {

        ModelAndView mv = new ModelAndView();
        /*
         *  根据id查找查找新闻详情，用于阅读
         */
        News news = newsService.findNewsById(nid);
        mv.addObject("news", news);

        /*
         *   分类查找新闻
         */
        String local = "5F8CA04B6A8B4219B7939091CAC0D659";
        String forien = "C114086D506C48248E63569B0E0FA345";
        String money = "CE7E35C77D9E4E14981E0EFFC00D7AFF";

        List<News> localNews = newsService.findKindsNews(local);
        List<News> forienNews = newsService.findKindsNews(forien);
        List<News> moneyNews = newsService.findKindsNews(money);

        mv.addObject("localnewss", localNews);
        mv.addObject("foriennewss", forienNews);
        mv.addObject("moneynewss", moneyNews);

        mv.setViewName("news_read");
        return mv;
    }

    /**
     * 退出并销毁所有session
     * @return
     */
    @RequestMapping("/quit.do")
    public String quit(HttpServletRequest request){
        HttpSession session = request.getSession();

        //销毁所有session
        session.invalidate();

        return "redirect:homeNews.do";
    }

}
