package codegym.com.test;

import codegym.com.test.model.CountryFomatter;
import codegym.com.test.service.CountryServiceIPL;
import codegym.com.test.service.ICountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
//    @Configuration
//    static class MyConfig extends WebMvcConfigurerAdapter {
//        @Override
//        public void addFormatters(FormatterRegistry registry) {
////            FormatterLocalDate formatterLocalDate = new FormatterLocalDate("yyyy-MM-dd");
//            registry.addFormatter(new CountryFomatter(ICountryService.));
//        }
//    }

}
