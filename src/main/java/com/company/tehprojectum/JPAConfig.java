package com.company.tehprojectum;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Created by kdiv on 3/13/17.
 */
@Configuration
@ConfigurationProperties()
//@ConfigurationProperties(prefix = "hibernate.hikari")
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {
//        "com.company.tehprojectum.domain.entity.User"
//})
public class JPAConfig extends HikariConfig {//PersistenceContext

//    LogManager propertyResolver;

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() throws SQLException {

//        LogManager propertyResolver = null;
//        if (propertyResolver.getProperty("url") == null && propertyResolver.getProperty("databaseName") == null) {
//            log.error("Your database connection pool configuration is incorrect! The application" +
//                            " cannot start. Please check your Spring profile, current profiles are: {}",
//                    Arrays.toString(env.getActiveProfiles()));
//
//            throw new ApplicationContextException("Database connection pool is not configured correctly");
//        }

//        HikariConfig config = new HikariConfig("/hikari.properties");
//
//        config.setDriverClassName(env.getRequiredProperty("dataSourceClassName"));
//        config.setJdbcUrl(env.getRequiredProperty("dataSource.url"));
//        config.setUsername(env.getRequiredProperty("dataSource.user"));
//        config.setPassword(env.getRequiredProperty("dataSource.password"));

         HikariConfig hikariConfig = new  HikariConfig("/hikari.properties");
      //  hikariConfig.setMaximumPoolSize(10);
//        hikariConfig.setDataSourceClassName("dataSourceClassName");
//        hikariConfig.setDriverClassName(null);
//        hikariConfig.setJdbcUrl("dataSource.url");
//        hikariConfig.setUsername("dataSource.user");
//        hikariConfig.setPassword("dataSource.password");

        return new HikariDataSource(hikariConfig);

//        HikariConfig config = new HikariConfig("some/path/hikari.properties");
//        HikariDataSource ds = new HikariDataSource(config);
    }
//    final HikariConfig hikariConfig = new  HikariConfig(absoluteFilePath);
//        this.hikariDataSource = new HikariDataSource(hikariConfig);

}