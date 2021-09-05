package dev.patika.patika0401.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomConfiguration implements WebMvcConfigurer {

    // methodlar üzerinden customized nesne dönmeyi sağlar
    @Bean
    public CustomInterceptor getInterceptor(){
        return new CustomInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**"); // /** ana pathden itibaren bütün pathlari al.
    }

}
