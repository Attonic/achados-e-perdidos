package io.github.achadoseperdidos.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.github.achadoseperdidos.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";
    private static final String ISSUE = "achados-e-perdidos-api";

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    @Value("${jwt.expiration.hours}")
    private int expirationHours;

    public String generateToken(Usuario user){
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);

        return JWT.create()
                .withIssuer(user.getEmail())
                .withClaim("id", user.getUsuarioId().toString())
                .withClaim("name", user.getUserName())
                .withExpiresAt(Instant.now().plus(expirationHours, ChronoUnit.HOURS))
                .sign(algorithm);
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUE)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {
            return null;
        }
    }

}
