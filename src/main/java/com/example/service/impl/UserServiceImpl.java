package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ServiceImpl是mybatis-plus提供的IService的实现类，自动为程序猿编写了很多的方法
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {




}
