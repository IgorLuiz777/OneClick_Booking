package br.com.oneclick.booking.api.auth;

import br.com.oneclick.booking.api.user.User;
import br.com.oneclick.booking.api.user.UserRepository;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.auth0.jwt.JWT;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    private Algorithm algorithm;

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public Token createToken(Credentials credentials) {
        var expiresAt = LocalDateTime.now().plusMonths(6).toInstant(ZoneOffset.ofHours(-3));
        String token = JWT.create()
                .withSubject(credentials.email())
                .withIssuer("oneClick_Booking")
                .withExpiresAt(expiresAt)
                .withClaim("role", "ADMIN")
                .sign(algorithm);
        return new Token(token, credentials.email());
    }

    public User getUserFromToken(String token) {
        var email = JWT.require(algorithm)
                .withIssuer("oneClick_Booking")
                .build()
                .verify(token)
                .getSubject();

        return userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "User not found with email: " + email));
    }
}

