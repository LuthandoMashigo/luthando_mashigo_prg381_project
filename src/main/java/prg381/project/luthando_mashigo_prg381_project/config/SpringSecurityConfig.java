package prg381.project.luthando_mashigo_prg381_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import prg381.project.luthando_mashigo_prg381_project.service.StudentService;

@Configuration
@EnableWebSecurity
//Only the Security Configuration with the Order with a lower number will have the Security Configuration active 
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private StudentService studentService;

     //This for encyrpting passwords and is neccessary for Spring Security to function
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(studentService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
            "/AdminRegistration**",
            "/StudentLogin",
            "/AdminLogin**", 
            "/AdminView**",
            "/LogoutAdmin**",
            "/AdminLogin?Logout",
            "/students",   
            "/students/**", 
            "/admin/**",  
            "/admins",      
            "/js/**",
            "/css/**",
            "/img/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/StudentLogin")
            .defaultSuccessUrl("/studentsview", true)
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/Logout"))
            .logoutSuccessUrl("/StudentLogin?Logout")
            .permitAll();
    }
    
    

}