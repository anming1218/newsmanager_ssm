package com.ming.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.Topic;
import com.ming.ssm.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 主题信息回显
     * @param tid
     * @return
     * @throws Exception
     */
    @RequestMapping("/echoTopic.do")
    public ModelAndView echoTopic(@RequestParam("tid") String tid) throws Exception {

        ModelAndView mv = new ModelAndView();
        Topic topic = service.findUserById(tid);

        mv.addObject("topic", topic);
        mv.setViewName("topic_update");

        return mv;
    }

    /**
     * 修改主题
     * @param request
     * @param topicname
     */
    @RequestMapping("/updateTopic.do")
    public String updateTopic(HttpServletRequest request, @RequestParam("tid") String tid, @RequestParam("topicname") String topicname) throws Exception {
        Topic topic = new Topic();
        topic.setTid(tid);
        topic.setTopicname(topicname);

        service.updateTopic(topic);
        return "redirect:findAll.do";
    }
}
