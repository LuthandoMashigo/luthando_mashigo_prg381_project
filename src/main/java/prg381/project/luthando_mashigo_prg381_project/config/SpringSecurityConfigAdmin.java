// package prg381.project.luthando_mashigo_prg381_project.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import prg381.project.luthando_mashigo_prg381_project.service.AdminService;

// @Configuration
// @EnableWebSecurity
// @Order(1)
// public class SpringSecurityConfigAdmin extends WebSecurityConfigurerAdapter{
    
//     @Autowired
//     private AdminService adminService;

//     @Bean
//     public BCryptPasswordEncoder pwEncoder(){
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public DaoAuthenticationProvider authenProvider() {
//         DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//         auth.setUserDetailsService(adminService);
//         auth.setPasswordEncoder(pwEncoder());
//         return auth;
//     }
    
    

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.authenticationProvider(authenProvider());
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests().antMatchers(
//             "/UpdateRegistar/**",
//             "/StudentRegistration**",
//             "/AdminRegistration**",
//             "/StudentLogin**",
//             "/StudentView**",
//             "/js/**",
//             "/css/**",
//             "/img/**").permitAll()
//             .anyRequest().authenticated()
//             .and()
//             .formLogin()
//             .loginPage("/AdminLogin")
//             .defaultSuccessUrl("/AdminView",true)
//             .permitAll()
//             .and()
//             .logout()
//             .invalidateHttpSession(true)
//             .clearAuthentication(true)
//             .logoutRequestMatcher(new AntPathRequestMatcher("/LogoutAdmin"))
//             .logoutSuccessUrl("/AdminLogin?Logout")
//             .permitAll();
//     }
// }


