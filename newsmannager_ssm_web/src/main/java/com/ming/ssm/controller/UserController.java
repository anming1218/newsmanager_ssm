package com.ming.ssm.controller;
import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.User;
import com.ming.ssm.service.UserService;
import com.ming.ssm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "8") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.findAll(page, size);

        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pb", pageInfo);
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

    /**
     * 用户信息回显
     * @param userid
     * @return
     * @throws Exception
     */
    @RequestMapping("/echoUser.do")
    public ModelAndView echoUser(@RequestParam("userid") String userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = userService.findUserById(userid);

        mv.addObject("user", user);
        mv.setViewName("user_update");

        return mv;
    }


    /**
     * 更新用户
     * @param request
     * @param userid
     * @param username
     * @param gender
     * @param age
     * @param email
     * @param oldpassword
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/update.do")
    public String updateUser(HttpServletRequest request, @RequestParam("userid") String userid, @RequestParam("username") String username, @RequestParam("gender") String gender, @RequestParam("age") String age,
                             @RequestParam("email") String email, @RequestParam("oldpassword") String oldpassword, @RequestParam("password") String password) throws Exception {

        User user = userService.findUserById(userid);
        oldpassword = MD5Utils.md5(oldpassword);
        if (oldpassword.equals(user.getPassword())) {
            User newUser = new User();
            newUser.setUserid(userid);
            newUser.setUsername(username);
            newUser.setGender(gender);
            newUser.setAge(Integer.parseInt(age));
            newUser.setEmail(email);
            newUser.setPassword(MD5Utils.md5(password));

            userService.updateUser(newUser);
            return "redirect:findAll.do";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("update_msg", "原密码输入错误！");
            return "forward:echoUser.do";
        }
    }

    /**
     * 根据id删除用户
     * @param userid
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteUser.do")
    public String deleteUser(@RequestParam("userid") String userid) throws Exception {
        userService.deleteUser(userid);

        return "forward:findAll.do";
    }

    /**
     * 删除选中的用户
     * @param request
     * @return
     */
    @RequestMapping("/deleteSelectUser.do")
    public String deleteSelectUser(HttpServletRequest request) throws Exception {

        String[] userids = request.getParameterValues("userid");

        userService.deleteSelectedUser(userids);

        return "forward:findAll.do";
    }

    /**
     * 模糊查询用户
     * @param page
     * @param size
     * @param username
     * @param age
     * @param email
     * @return
     */
    @RequestMapping("/findLikeUser.do")
    public ModelAndView findLikeUser(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "8") int size, @RequestParam("username_like") String username, @RequestParam("age_like") String age, @RequestParam("email_like") String email) {

        ModelAndView mv = new ModelAndView();
        List<User> likeUser = userService.findLikeUser(page, size, username, Integer.parseInt(age), email);
        PageInfo pageInfo = new PageInfo(likeUser);
        mv.addObject("pb", pageInfo);
        mv.setViewName("user_list");
        return mv;
    }
}
