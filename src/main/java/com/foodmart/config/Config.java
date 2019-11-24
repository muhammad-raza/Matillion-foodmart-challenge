package com.foodmart.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jmx.export.MBeanExporter;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HikariConfig hikariConfig() {
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setPoolName("springHikariCP");
        hikariConfig.setConnectionTimeout(15 * 1000);

        return hikariConfig;
    }

    @Bean
    public DataSource hikariDataSource(final HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    // Had to exclude hikari data source as
    // MBean was trying to create duplicate beans
    @Bean
    public MBeanExporter exporter()
    {
        final MBeanExporter exporter = new MBeanExporter();
        exporter.setAutodetect(true);
        exporter.setExcludedBeans("hikariDataSource", "hikariConfig");
        return exporter;
    }

}
