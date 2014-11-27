package myrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ibekesi on 2014.11.27..
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        System.out.println("********************************** Configure");
        configurer.
                defaultContentType(MediaType.APPLICATION_JSON).
                mediaType(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON).
                mediaType(MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XML).
                mediaType("xml", MediaType.APPLICATION_XML);


    }
}