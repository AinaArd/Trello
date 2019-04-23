package ru.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.security.utils.AuthFailureHandler;
import ru.itis.security.utils.AuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public final PasswordEncoder passwordEncoder;
    public final AuthSuccessHandler authSuccessHandler;
    public final AuthFailureHandler authFailureHandler;
    public final UserDetailsService service;

    @Autowired
    public SecurityConfig(AuthSuccessHandler successHandler, AuthFailureHandler failureHandler, PasswordEncoder passwordEncoder, @Qualifier("userDetailsServiceImpl") UserDetailsService service) {
        this.passwordEncoder = passwordEncoder;
        this.service = service;
        this.authSuccessHandler = successHandler;
        this.authFailureHandler = failureHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/desks/**").authenticated()
                .antMatchers("/cards/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
//                    .successHandler(authSuccessHandler)
////                    .failureHandler(authFailureHandler)
                .defaultSuccessUrl("/profile")
                .usernameParameter("login")
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me");

        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }
}

