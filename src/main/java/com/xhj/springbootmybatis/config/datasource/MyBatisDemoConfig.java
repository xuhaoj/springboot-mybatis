package com.xhj.springbootmybatis.config.datasource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author : xhj
 */
@Configuration
@MapperScan(basePackages = "com.xhj.springbootmybatis.domain.mybatisdemo.dao*", sqlSessionFactoryRef = "mybatisdemoSqlSessionFactory", sqlSessionTemplateRef = "mybatisdemoSqlSessionTemplate")
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
public class MyBatisDemoConfig {

    private final DataSource dataSource;

    public MyBatisDemoConfig(@Qualifier("mybatisDemoDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean("mybatisdemoSqlSessionFactory")
    public SqlSessionFactory mybatisdemoSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xhj.springbootmybatis.domain.mybatisdemo.model");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:**/*Mapper.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setLogImpl(StdOutImpl.class); //本地可开启，线上建议关闭
        sqlSessionFactoryBean.setConfiguration(configuration);
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "false");
        interceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(interceptor);
        return sqlSessionFactoryBean.getObject();
    }


    @Bean("mybatisdemoSqlSessionTemplate")
    public SqlSessionTemplate jackSqlSessionTemplate(@Qualifier("mybatisdemoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public PlatformTransactionManager mybatisdemoTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
