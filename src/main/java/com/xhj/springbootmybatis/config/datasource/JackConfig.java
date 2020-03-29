package com.xhj.springbootmybatis.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author : xhj
 */
@Configuration
@MapperScan(basePackages = "com.xhj.springbootmybatis.domain.jack.dao", sqlSessionFactoryRef = "jackSqlSessionFactory", sqlSessionTemplateRef = "jackSqlSessionTemplate")
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
public class JackConfig {

    private final DataSource dataSource;

    public JackConfig(@Qualifier("jackDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Primary
    @Bean("jackSqlSessionFactory")
    public SqlSessionFactory jackSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xhj.springbootmybatis.domain.jack.model");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:**/*Mapper.xml"));
        //PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "false");
        //interceptor.setProperties(properties);
        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor});
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean("jackSqlSessionTemplate")
    public SqlSessionTemplate jackSqlSessionTemplate(@Qualifier("jackSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean
    public PlatformTransactionManager jackTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
