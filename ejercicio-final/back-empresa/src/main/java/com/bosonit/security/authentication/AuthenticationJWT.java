package com.bosonit.security.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bosonit.domain.no_collection.BackEmpresaSecurityToken;
import com.bosonit.security.configuration.ConstantsConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;


@AllArgsConstructor
public class AuthenticationJWT extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getParameter(ConstantsConfiguration.USERNAME),
                        request.getParameter(ConstantsConfiguration.PASSWORD)
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException, ServletException {

        User user = (User) authentication.getPrincipal();
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + ConstantsConfiguration.EXPIRATION_TIME))
                .withIssuer(request.getRequestURL().toString())
                .withClaim(ConstantsConfiguration.ROLES, user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(Algorithm.HMAC256(ConstantsConfiguration.SECRET.getBytes()));

        HashMap<String, String> token = new HashMap<>();
        token.put("access_token", access_token);
        new ObjectMapper().writeValue(response.getOutputStream(), token);
    }
}