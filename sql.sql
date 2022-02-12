create database db_account;

use db_account;

drop table if exists account_tbl;
create table account_tbl(
    id int(11) primary key auto_increment,
    user_id varchar(255),
    money int(11)
);

insert into account_tbl(`user_id`,money) values('1001',9995);
insert into account_tbl(`user_id`,money) values('1002',10000);

# ----------------------------------------------------------------------------
CREATE TABLE city
(
    id      INT(11) PRIMARY KEY auto_increment,
    name    VARCHAR(255),
    state   VARCHAR(255),
    country VARCHAR(255)
);

insert into city(`name`,`state`,`country`) values('合肥','安徽','中国');
insert into city(`name`,`state`,`country`) values('池州','安徽','中国');

# ----------------------------------------------------------------------------

# 模拟mybatis-plus测试用的表
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

INSERT INTO user (id, name, age, email) VALUES
/*(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com'),*/
(6, 'Jone', 18, 'test6@baomidou.com'),
(7, 'Jack', 20, 'test7@baomidou.com'),
(8, 'Tom', 28, 'test8@baomidou.com'),
(9, 'Sandy', 21, 'test9@baomidou.com'),
(10, 'Billie', 24, 'test10@baomidou.com'),
(11, 'Jone', 18, 'test11@baomidou.com'),
(12, 'Jack', 20, 'test12@baomidou.com'),
(13, 'Tom', 28, 'test13@baomidou.com'),
(14, 'Sandy', 21, 'test14@baomidou.com'),
(15, 'Billie', 24, 'test15@baomidou.com');

;

;


