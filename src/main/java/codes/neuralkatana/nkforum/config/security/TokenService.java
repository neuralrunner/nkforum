package codes.neuralkatana.nkforum.config.security;

import codes.neuralkatana.nkforum.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${nkforum.dev.jwt.expiration}")
    private String expiration;

    @Value("${nkforum.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();
        Date now = new Date();
        Date dateExpiration = new Date(now.getTime()+Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("NKForum")
                .setSubject(logged.getId().toString())
                .setIssuedAt(now)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
}
