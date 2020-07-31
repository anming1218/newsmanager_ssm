package com.ming.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.Topic;
import com.ming.ssm.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 主题的表现层接口
 *@author: ming
 *@create: 2020-07-30 16:59
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService service;

    /**
     * 查询所有主题
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "8") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Topic> list = service.findAll(page, size);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pb", pageInfo);
        mv.setViewName("topic_list");
        return mv;
    }

    /**
     * 增加主题
     * @param topic
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveTopic.do")
    public String saveTopic(Topic topic) throws Exception {
        service.saveTopic(topic);
        return "redirect:findAll.do";
    }
}
