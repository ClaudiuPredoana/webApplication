package com.predoana.app.web.config;

import com.predoana.app.web.dao.JdbcUserDAO;
import com.predoana.app.web.dao.UserDAO;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @DatabaseType("MYSQL")
    public UserDAO jdbcUserDAO() {
        return (UserDAO) new JdbcUserDAO();
    }

}
