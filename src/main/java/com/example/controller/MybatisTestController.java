package com.example.controller;

import com.example.bean.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MybatisTestController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    @ResponseBody
    public Account getAccountById(@RequestParam("id")Integer id){

        return accountService.getAccountById(id);
    }

}
