package vn.codegym.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import vn.codegym.student_management.formatter.LocalDateFormatter;

@SpringBootApplication
public class QuestionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionManagementApplication.class, args);
    }
    @Configuration
    static class MyConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new LocalDateFormatter("yyyy-MM-dd"));
        }
    }
}
