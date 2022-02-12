package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class SpringbootApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {

        //jdbcTemplate.queryForList("select * from account_tbl");'
        Long result = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);

        log.info("记录总数:{}",result);
        log.info("数据源类型:{}",dataSource.getClass());
    }

}
