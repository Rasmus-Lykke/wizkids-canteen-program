package kea.examgroup.wizkidscanteenprogram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/*
 * Authors: Rasmus
 *
 * The primary security class for the program.
 * This class uses the spring annotations, to create a database table
 * and automatic getters and setters for the class.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    // Method which handles the Http security.
    // This method gives access to folders, pages, and files based on the type of role the user has
    // and based on whether the user i logged in or not. It also defines to login page and which page to redirect
    // the user tho when he/she has successfully logged out ot in. And much more.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/createuser", "/createnewuser", "/css/**", "/images/**", "/test", "/canteenmenu").permitAll()
                .antMatchers("/personelforum", "/personelhelp", "/personelmenu", "/personelorders", "/createorder").hasRole("USER")
                .antMatchers("/canteenforum", "/canteenhelp", "/canteenorders", "/canteenemail").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/menu", true)
                .permitAll()
                .and()
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    // Method which handles the login credentials and check if the user is already registred in the system
    // and compares the input with the saved username and password information
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM wizkidsusers WHERE username=?")
                .authoritiesByUsernameQuery("SELECT wizkidsusers.username AS username, " +
                        "authorities.authority AS authority " +
                        "FROM wizkidsusers JOIN authorities " +
                        "ON wizkidsusers.id = authorities.wizkidsuser_id " +
                        "WHERE wizkidsusers.username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired
    public void initialize(AuthenticationManagerBuilder builder, DataSource dataSource) throws Exception {
        builder.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource);
    }

    // Password encode for the encryption.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}