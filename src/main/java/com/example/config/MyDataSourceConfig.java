package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        //配置druid监控功能
        //加上 wall，表示添加上防火墙的功能
        druidDataSource.setFilters("stat,wall");

        return druidDataSource;
    }

    //给容器中放入一个servlet,配置druid的监控页功能
    @Bean
    public ServletRegistrationBean statViewServlet(){

        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");

        //配置登录监控页时的登录名和密码
        registrationBean.addInitParameter("loginUsername","root");
        registrationBean.addInitParameter("loginPassword","123456");

        return registrationBean;
    }

    /**
     * 开启druid web关联监控
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){

        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);

        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }

}
