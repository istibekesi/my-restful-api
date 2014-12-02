package myrest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ibekesi on 2014.11.27..
 */
@Configuration
@ComponentScan
@EnableWebMvc
//@EnableHypermediaSupport
public class WebConfig extends WebMvcConfigurerAdapter {
//public class WebConfig extends WebMvcConfigurationSupport {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        System.out.println("********************************** Configuring ContentNegotiation...");

        configurer
                .favorPathExtension(false)
                .defaultContentType(MediaType.APPLICATION_JSON);

        System.out.println("********************************** Configure ContentNegotiation DONE!");
    }

}