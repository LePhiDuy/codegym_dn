package vn.codegym.student_management.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MyConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource message = new ResourceBundleMessageSource();
        message.setBasename("messageError");
        message.setDefaultEncoding("UTF-8");
        return message;
    }
}
