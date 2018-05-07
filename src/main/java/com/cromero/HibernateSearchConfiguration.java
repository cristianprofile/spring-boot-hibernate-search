package com.cromero;

import com.cromero.service.HibernateSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfiguration {

    @Autowired
    private EntityManager bentityManager;

    @Bean
    HibernateSearchServiceImpl hibernateSearchService() {
        HibernateSearchServiceImpl hibernateSearchServiceImpl = new HibernateSearchServiceImpl(bentityManager);
        hibernateSearchServiceImpl.initializeHibernateSearch();
        return hibernateSearchServiceImpl;
    }
}