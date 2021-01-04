package com.spring.learndi.config;

import com.spring.learndi.examplebeans.FakeDataSource;
import com.spring.learndi.examplebeans.FakeJmsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//Ex1 @PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    //Just a capability , not a good way to handle, but this way can force to change property retrieval name (Martynas.dburl vs
    //dburl)
    @Autowired
    Environment env;

    @Value("${martynas.username}")
    String user;
    @Value("${martynas.password}")
    String password;
    @Value("${martynas.dburl}")
    String url;
    @Value("${martynas.jms.username}")
    String jmsUsername;
    @Value("${martynas.jms.password}")
    String jmsPassword;
    @Value("${martynas.jms.dburl}")
    String jmsUrl;
    @Value("${martynas.user}")
    String secondUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(env.getProperty("DBURL"));
        return fakeDataSource;
    }

    @Bean
    public FakeJmsSource fakeJmsSource() {
        FakeJmsSource fakeJmsSource = new FakeJmsSource();
        fakeJmsSource.setJmsName(jmsUsername);
        fakeJmsSource.setJmsPassword(jmsPassword);
        fakeJmsSource.setJmsUrl(jmsUrl);
        fakeJmsSource.setSecondUrl(secondUrl);
        return fakeJmsSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }
}
