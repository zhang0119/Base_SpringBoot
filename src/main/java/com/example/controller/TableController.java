package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){

        int result = 10/0;
        return "tables/basic_table";
    }

    /**
     * 处理删除用户的控制器
     *
     * RedirectAttributes 这个对象可以携带数据使用重定向的方式
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id,
                             @RequestParam(value="pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);

        ra.addAttribute("pn",pn);

        //删除用户后还回到原来的页面
        return "redirect:/dynamic_table";
    }



    /**
     *
     * 请求url中携带一个pn参数，从前端传递到后端，没有传递的话，默认值是1
     */
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1")Integer pn , Model model){

        //从数据库中查出user表中的用户进行展示
        List<User> userList = userService.list();

        //mybatis-plus提供一个一个分页查询数据的方法page()
        Page<User> userPage = new Page<>(pn, 2);
        //这个page对象是分页查询的结果,这个page对象中包含了很多信息,可以试试page.getXXX
        Page<User> page = userService.page(userPage, null);

        //现在直接把page对象放入到model对象里面，用户信息是调用page对象的getTotal()方法
        model.addAttribute("page",page);

        //model.addAttribute("userList",userList);

        //表格内容的遍历
        /*List<User> users = Arrays.asList(new User("kazuha","123456"),
                                        new User("ayaka","123456"),
                                        new User("diona","123456"),
                                        new User("thoma","123456"));
        model.addAttribute("users",users);*/

        return "tables/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "tables/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "tables/editable_table";
    }

}
