package com.predoana.app.web.config;

import com.predoana.app.web.dao.JdbcUserDAO;
import com.predoana.app.web.dao.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @Conditional(MySQLDatabaseTypeCondition.class)
    public UserDAO jdbcUserDAO() {
        return new JdbcUserDAO();
    }

}
