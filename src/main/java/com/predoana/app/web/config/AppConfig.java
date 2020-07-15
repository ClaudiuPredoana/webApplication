package com.predoana.app.web.config;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource(value = { "classpath:application.properties" })

public class AppConfig {
    @Autowired
    private Environment env;
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()    {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Value("${init-db:false}")
    private String initDatabase;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)    {
        return new JdbcTemplate(dataSource);    }
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource)    {
        return new DataSourceTransactionManager(dataSource);    }

    @Bean
    public DataSource dataSource()    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;    }

    @Bean
    public DataSourceInitializer dataSourceInitializer (DataSource dataSource)
    {        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    dataSourceInitializer.setDataSource(dataSource);

    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();

    databasePopulator.addScript(new ClassPathResource("sql/data.sql"));
    dataSourceInitializer.setDatabasePopulator(databasePopulator);
    dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
    return dataSourceInitializer;    } }

