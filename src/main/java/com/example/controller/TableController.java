package com.example.controller;

import com.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){

        int result = 10/0;
        return "tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){

        //表格内容的遍历
        List<User> users = Arrays.asList(new User("kazuha","123456"),
                                        new User("ayaka","123456"),
                                        new User("diona","123456"),
                                        new User("thoma","123456"));
        model.addAttribute("users",users);

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
