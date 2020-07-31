package com.ming.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.User;
import com.ming.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *@program: newsmannager_ssm
 *@description: 用户的表现层控制
 *@author: ming
 *@create: 2020-07-30 13:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "8") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.findAll(page,size);

        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pb",pageInfo);
        mv.setViewName("user_list");
        return mv;
    }

    /**
     * 保存用户
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("saveUser.do")
    public String saveUser(User user) throws Exception {
        userService.saveUser(user);

        return "redirect:findAll.do";
    }

}
