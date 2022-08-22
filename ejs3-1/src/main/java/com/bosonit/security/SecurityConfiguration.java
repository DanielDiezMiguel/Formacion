package com.bosonit.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("secret"))
                .roles("USER").build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("secret"))
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        AuthenticationJWT authenticationJWT = new AuthenticationJWT(authenticationManagerBean());
        authenticationJWT.setFilterProcessesUrl("/api/login");
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/login/**").permitAll().and()
                .authorizeRequests()
                .anyRequest()
                .authenticated().and()
                .addFilter(authenticationJWT)
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}