package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

@SpringBootApplication
@Configuration
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    FilterRegistrationBean dispatherFilter(){
        FilterDispatcher filterDispatcher = new FilterDispatcher();
        return new FilterRegistrationBean(filterDispatcher);
    }

    @Bean
    FilterRegistrationBean cleanUpFilter(){
        ActionContextCleanUp actionContextCleanUp = new ActionContextCleanUp();
        return  new FilterRegistrationBean(actionContextCleanUp);
    }

    @Bean
    FilterRegistrationBean pageFilter(){
        PageFilter pageFilter = new PageFilter();
        return new FilterRegistrationBean(pageFilter);
    }
}
