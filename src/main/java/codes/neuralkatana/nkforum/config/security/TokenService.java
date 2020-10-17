package codes.neuralkatana.nkforum.config.security;

import codes.neuralkatana.nkforum.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    //Gets the expiration value from application.properties
    @Value("${nkforum.dev.jwt.expiration}")
    private String expiration;

    //Gets the secret string for the token generation from application.properties
    @Value("${nkforum.jwt.secret}")
    private String secret;

    //Generate the token for user
    public String generateToken(Authentication authentication) {
        //gets the User object from authentication
        User logged = (User) authentication.getPrincipal();
        //Generates the now Date/time and generates the expiration for the token
        Date now = new Date();
        Date dateExpiration = new Date(now.getTime()+Long.parseLong(expiration));
        //Returns a json web token
        return Jwts.builder()
                .setIssuer("NKForum")
                .setSubject(logged.getId().toString())
                .setIssuedAt(now)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public boolean isValid(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Long getUserId(String token) {
        Claims claim = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claim.getSubject());
    }
}
