package com.poojitha.ewallet.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@Service
public class JwtTokenService {

    private static final String SECRET =
            "DigitalWalletSecretKey";

    public String generateToken(String email,
                                String role) {

        String payload =
                email +
                ":" +
                role +
                ":" +
                UUID.randomUUID() +
                ":" +
                LocalDateTime.now();

        return Base64.getEncoder()
                .encodeToString(
                        (payload + SECRET).getBytes()
                );
    }

    public boolean validateToken(String token) {

        if (token == null || token.isBlank()) {
            return false;
        }

        try {

            String decoded =
                    new String(
                            Base64.getDecoder()
                                    .decode(token)
                    );

            return decoded.endsWith(SECRET);

        } catch (Exception exception) {

            return false;

        }

    }

    public String extractEmail(String token) {

        if (!validateToken(token)) {
            return "";
        }

        String decoded =
                new String(
                        Base64.getDecoder()
                                .decode(token)
                );

        return decoded.split(":")[0];
    }

    public String extractRole(String token) {

        if (!validateToken(token)) {
            return "";
        }

        String decoded =
                new String(
                        Base64.getDecoder()
                                .decode(token)
                );

        return decoded.split(":")[1];
    }

}
