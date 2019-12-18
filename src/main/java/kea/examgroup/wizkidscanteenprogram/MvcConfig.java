package kea.examgroup.wizkidscanteenprogram;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Authors: Rasmus
 *
 * The primary security class for the program.
 * This class uses the spring annotations, to create a database table
 * and automatic getters and setters for the class.
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // Our primary view controller
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
