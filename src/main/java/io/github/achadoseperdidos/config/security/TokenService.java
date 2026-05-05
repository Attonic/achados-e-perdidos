package io.github.achadoseperdidos.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";
    private static final String ISSUE = "achados-e-perdidos-api";

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    private int expirationHours;


}
