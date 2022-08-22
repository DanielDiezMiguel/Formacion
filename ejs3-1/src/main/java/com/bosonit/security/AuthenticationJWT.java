package com.bosonit.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@AllArgsConstructor
public class AuthenticationJWT extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getParameter("username"),
                        request.getParameter("password")
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        String access_token = JWT.create()
                .withSubject(
                        user.getUsername())
                .withExpiresAt(
                        new Date(System.currentTimeMillis() + AuthenticationConfigConstants.EXPIRATION_TIME))
                .withIssuer(request
                        .getRequestURL().toString())
                .sign(Algorithm
                        .HMAC256(AuthenticationConfigConstants
                                .SECRET.getBytes()
                        )
                );
        Map<String, String> token = new HashMap<>();
        token.put("access_token", AuthenticationConfigConstants.TOKEN_PREFIX + access_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), token);
//        response.addHeader(AuthenticationConfigConstants.HEADER_STRING, AuthenticationConfigConstants.TOKEN_PREFIX
//                + JWT.create()
//                .withSubject(
//                        user.getUsername())
//                .withExpiresAt(
//                        new Date(System.currentTimeMillis() + AuthenticationConfigConstants.EXPIRATION_TIME))
//                .sign(Algorithm.HMAC256(AuthenticationConfigConstants.SECRET.getBytes()))
//        );
    }
}