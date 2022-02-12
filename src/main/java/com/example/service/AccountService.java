package com.example.service;

import com.example.bean.Account;
import com.example.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountById(Integer id){
        return accountMapper.getAccount(id);
    }

}
