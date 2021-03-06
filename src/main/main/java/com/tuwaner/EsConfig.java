package com.tuwaner;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * @date 2018/7/13
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.tuwaner.book.repository")
public class EsConfig {

    @Value("192.168.56.102")
    private String EsHost;

    @Value("9300")
    private int EsPort;

    @Value("my-application")
    private String EsClusterName;

    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder().put("cluster.name", EsClusterName).build();
        return new PreBuiltTransportClient(esSettings).addTransportAddress(
            new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));

    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
