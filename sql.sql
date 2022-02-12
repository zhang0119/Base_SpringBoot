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