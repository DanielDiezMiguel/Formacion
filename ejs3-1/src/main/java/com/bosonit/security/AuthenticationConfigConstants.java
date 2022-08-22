package com.bosonit.security;

public class AuthenticationConfigConstants {
    public static final String SECRET = "secret";
    public static final long EXPIRATION_TIME = 600000; // 10 min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
