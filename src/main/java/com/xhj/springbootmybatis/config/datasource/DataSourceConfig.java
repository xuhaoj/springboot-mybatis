package com.xhj.springbootmybatis.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置
 *
 * @author :xhj
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "jackDataSource")
    @ConfigurationProperties("spring.datasource.jack")
    public DataSource jackDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

/*    @Bean(name = "hermesHikariDataSource")
    @Qualifier("hermesHikariDataSource")
    @ConfigurationProperties("spring.datasource.hikari.hermes")
    public DataSource hermesHikariDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }*/

}
