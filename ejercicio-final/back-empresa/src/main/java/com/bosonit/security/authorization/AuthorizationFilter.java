package com.bosonit.security.authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.bosonit.security.configuration.ConstantsConfiguration.*;
import static java.util.Arrays.stream;

@Slf4j
public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String token = httpServletRequest.getHeader(HEADER_STRING);
        if (token == null) filterChain.doFilter(httpServletRequest, httpServletResponse);
        else {
            DecodedJWT verifyToken =
                    JWT.require(Algorithm.HMAC256(SECRET.getBytes()))
                            .build()
                            .verify(token.replace(TOKEN_PREFIX, ""));

            String user = verifyToken.getSubject();
            String[] roles = verifyToken.getClaim("roles").asArray(String.class);

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            stream(roles).forEach(rol -> authorities
                    .add(new SimpleGrantedAuthority(rol)));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(user, null, authorities));

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}