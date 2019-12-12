package kea.examgroup.wizkidscanteenprogram;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/personelorders").setViewName("personelorders");
        registry.addViewController("/personelforum").setViewName("personelforum");
        registry.addViewController("/personelmenu").setViewName("personelmenu");
        registry.addViewController("/personelhelp").setViewName("personelhelp");

        registry.addViewController("/canteenmenu").setViewName("canteenmenu");
        registry.addViewController("/canteenemail").setViewName("canteenemail");
        registry.addViewController("/canteenforum").setViewName("canteenforum");
        registry.addViewController("/canteenhelp").setViewName("canteenhelp");
        registry.addViewController("/canteenorders").setViewName("canteenorders");

        registry.addViewController("/createuser").setViewName("createuser");
        registry.addViewController("/createnewuser").setViewName("createnewuser");

        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");

    }

}
