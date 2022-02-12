package com.example.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")  //指定表的名字，默认和表名是一一对应的
public class User {

    //这个注解表示这个字段不是数据库表字段，mybatis-plus提供的注解，即表字段标识
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    //这是user表的字段
    private Integer id;
    private String name;
    private Integer age;
    private String email;

}
