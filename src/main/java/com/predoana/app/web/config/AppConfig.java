package com.predoana.app.web.config;

import org.springframework.beans.factory.annotation.Value;

public class AppConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

}
