package in.chandan.moneymanager.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String email) {
        System.out.println("key: " + secretKey);

        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

}
