package com.bosonit.security.configuration;

import com.bosonit.security.authentication.AuthenticationJWT;
import com.bosonit.security.authorization.AuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
                .username(ConstantsConfiguration.USER)
                .password(passwordEncoder().encode(ConstantsConfiguration.SECRET))
                .roles(ConstantsConfiguration.ROL_USER).build();
        UserDetails admin = User.builder()
                .username(ConstantsConfiguration.ADMIN)
                .password(passwordEncoder().encode(ConstantsConfiguration.SECRET))
                .roles(ConstantsConfiguration.ROL_ADMIN).build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        AuthenticationJWT authenticationJWT = new AuthenticationJWT(authenticationManagerBean());
        authenticationJWT.setFilterProcessesUrl("/api/v0/login");
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v0/disponible/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v0/disponible/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/api/v0/security/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .addFilterBefore(new AuthorizationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilter(authenticationJWT);
    }
}