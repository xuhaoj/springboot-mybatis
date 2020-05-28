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
 * 数据源配置
 * @author :xhj
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "mybatisDemoDataSource")
    @ConfigurationProperties("spring.datasource.hikari.mybatisdemo")
    public DataSource jackDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


/*    @Bean(name = "crmproductHikariDataSource")
    @Qualifier("crmproductHikariDataSource")
    @ConfigurationProperties("spring.datasource.hikari.crmproduct")
    public DataSource crmproductHikariDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }*/

}
