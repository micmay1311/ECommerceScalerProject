package com.capstone.EComProductService.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.Header;

import org.apache.http.ssl.SSLContextBuilder;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.elasticsearch.client.RestClient;


import javax.net.ssl.SSLContext;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;

@Configuration
public class ElasticsearchConfig {
    @Value("${elasticsearch.host}")
    private String elasticHost;

    @Value("${elasticsearch.username}")
    private String username;

    @Value("${elasticsearch.password}")
    private String password;

    @Bean
    public ElasticsearchClient elasticsearchClient() throws URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
////        String auth = username + ":" + password;
////        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
////
////        RestClient restClient = RestClient.builder(HttpHost.create(elasticHost))
////                .setDefaultHeaders(new Header[]{
////                        new BasicHeader("Authorization", "Basic " + encodedAuth)
////                })
////                .build();
//
//        // Create credentials provider
//        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(
//                AuthScope.ANY,
//                new UsernamePasswordCredentials(username, password)
//        );
//
//        // Bypass SSL cert validation (NOT FOR PROD)
//        SSLContext sslContext = SSLContextBuilder.create()
//                .loadTrustMaterial(null, (TrustStrategy) (X509Certificate[] chain, String authType) -> true)
//                .build();
//
//        // Build RestClient with basic auth
//        RestClientBuilder builder = RestClient.builder(
//                        new HttpHost(elasticHost, 9200, "https"))
//                .setHttpClientConfigCallback(httpClientBuilder ->
//                        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
//                );
//
//        // Build the low-level REST client
//        RestClient restClient = builder.build();
//
//        ElasticsearchTransport transport = new RestClientTransport(
//                restClient, new JacksonJsonpMapper());
//
//        return new ElasticsearchClient(transport);
//    }
        // Ignore certificate trust (ONLY for dev!)
        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true)
                .build();

        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        RestClientBuilder builder = RestClient.builder(HttpHost.create(elasticHost))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setSSLContext(sslContext)
                        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                        .setDefaultCredentialsProvider(credentialsProvider)
                );

        RestClient restClient = builder.build();
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }
}
