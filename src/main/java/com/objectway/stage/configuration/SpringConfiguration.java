package com.objectway.stage.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;

@Configuration
public class SpringConfiguration {

//    @Autowired
//    private InternalResourceViewResolver internalResourceViewResolver;
//
//
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver() {
//
//        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
//        internalResourceViewResolver.setSuffix(".jsp");
//
//        return internalResourceViewResolver;
//
//    }


    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource(){

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/Hospital");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");

        return basicDataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource basicDataSource, HibernateJpaVendorAdapter hibernateJpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setPackagesToScan("com.objectway.stage");
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setDataSource(basicDataSource);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");

        return hibernateJpaVendorAdapter;
    }


    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactoryBean) {

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();

        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean);

        return jpaTransactionManager;
    }




}
