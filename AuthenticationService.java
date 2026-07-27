package com.poojitha.ewallet.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final Map<String, String> users = new HashMap<>();

    public AuthenticationService() {

        users.put("admin@wallet.com", "admin123");
        users.put("john@wallet.com", "john123");
        users.put("alice@wallet.com", "alice123");

    }

    public String authenticate(String email,
                               String password) {

        if (!users.containsKey(email)) {
            return "Authentication Failed";
        }

        if (!users.get(email).equals(password)) {
            return "Authentication Failed";
        }

        if (!performMultiFactorAuthentication(email)) {
            return "MFA Validation Failed";
        }

        return generateJwtToken(email);

    }

    private boolean performMultiFactorAuthentication(
            String email) {

        System.out.println("MFA Verification Started");
        System.out.println("User : " + email);
        System.out.println("Verification Time : "
                + LocalDateTime.now());

        return true;

    }

    private String generateJwtToken(String email) {

        String token = UUID.randomUUID()
                .toString()
                .replace("-", "");

        System.out.println("JWT Generated");
        System.out.println("User : " + email);

        return token;

    }

    public boolean validateToken(String token) {

        return token != null
                && token.length() > 20;

    }

    public boolean hasAdminRole(String role) {

        return "ADMIN".equalsIgnoreCase(role);

    }

    public boolean hasCustomerRole(String role) {

        return "CUSTOMER".equalsIgnoreCase(role);

    }

}
