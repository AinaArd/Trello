package ru.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import ru.itis.security.utils.AuthFailureHandler;
import ru.itis.security.utils.AuthSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public AuthSuccessHandler authSuccessHandler;

    @Autowired
    public AuthFailureHandler authFailureHandler;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    public UserDetailsService service;

    @Autowired
    private DataSource dataSource;

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
                .antMatchers("/register/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/desks/**").authenticated()
                .antMatchers("/cards/**").authenticated()
                .antMatchers("/tasks/**").authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/profile")
                .usernameParameter("login")
                .and()

                .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenRepository(tokenRepository());

        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }
}

