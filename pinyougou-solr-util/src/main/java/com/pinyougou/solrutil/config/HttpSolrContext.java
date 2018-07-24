package com.pinyougou.solrutil.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:solr.properties")
@EnableSolrRepositories("com.pinyougou.solrutil.repository")
public class HttpSolrContext {
    private static final String SOLR_SERVER_URL ="solr.server.url";

    @Resource
    private Environment environment;

    @Bean
    public SolrClient solrClient(){
//        return new HttpSolrClient(environment.getRequiredProperty(SOLR_SERVER_URL));
        return new  HttpSolrClient.Builder(environment.getRequiredProperty(SOLR_SERVER_URL)).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client){
        return new SolrTemplate(client);
    }
}
