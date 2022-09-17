package com.example.confi;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")

public class AppConf implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false)
  ;
    registry.setOrder(1);
    }
@Bean
    public ViewResolver viewResolver(){
    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//    new InternalResourceViewResolver()
internalResourceViewResolver.setViewClass(JstlView.class);

    internalResourceViewResolver.setSuffix(".jsp");
    internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
    return internalResourceViewResolver;}
@Bean
    public JdbcTemplate jdbcTemplate(){
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
    driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/2-savol");
    driverManagerDataSource.setUsername("postgres");
    driverManagerDataSource.setPassword("123");
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    jdbcTemplate.setDataSource(driverManagerDataSource);
    return jdbcTemplate;
}
}
