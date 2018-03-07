package com.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * SpringBoot 启动类
 *
 * @author ht000254
 * @version 1.0
 * @create 2017-03-28 9:57
 **/
@SpringBootApplication
@EnableTransactionManagement
//@EnableScheduling
public class Application {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return builder.additionalMessageConverters(m).build();
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
