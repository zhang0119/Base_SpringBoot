package com.example.controller;

import com.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFormDB(){

        Long result = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        return result.toString();
    }

    /**
     * 去登陆页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    /*---------下面这两个方法是防止表单的重复提交问题-----------------------------------------------------------*/
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())){
            //把登录成功后的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功后再重定向到main.html；重定向防止表达的重复提价
            return "redirect:/main.html";
        }else {

            //把错误消息放到model对象中
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        //当我们使用了拦截器后，下面的代码就多余了，直接注释
        //判断用户是否登录
        /*Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null ){
            return "main";
        }else {
            //回到登录页
            //携带错误的登录信息
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/

        return "main";
    }

    /*--------------------------------------------------------------------*/
}
