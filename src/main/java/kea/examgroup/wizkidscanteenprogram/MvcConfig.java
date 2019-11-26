package kea.examgroup.wizkidscanteenprogram;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/createuser").setViewName("createuser");
        registry.addViewController("/orders").setViewName("orders");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/createmenu").setViewName("createmenu");
        registry.addViewController("/menu").setViewName("menu");
    }

}
