package br.com.oneclick.booking.api.auth;

import br.com.oneclick.booking.api.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    public Token login(Credentials credentials) {
        var user = userRepository.findByEmail(credentials.email()).orElseThrow(() -> new RuntimeException("Access denied!"));

        if (!passwordEncoder.matches(credentials.password(), user.getPassword())) {
            throw new RuntimeException("Access denied!");
        }
        return tokenService.createToken(credentials);
    }


}
