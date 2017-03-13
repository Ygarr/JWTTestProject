package com.company.tehprojectum;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * for HikariCP - PersistenceContext
 *
 * Created by kdiv on 3/13/17.
 */
@Configuration
@ConfigurationProperties()
public class JPAConfig extends HikariConfig {

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() throws SQLException {

        HikariConfig hikariConfig = new HikariConfig("/hikari.properties");

        return new HikariDataSource(hikariConfig);

    }


}