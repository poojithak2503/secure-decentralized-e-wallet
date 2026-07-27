package com.poojitha.ewallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SecurityConfiguration {

    @Bean
    public List<String> publicEndpoints() {

        return List.of(
                "/api/wallet/login",
                "/api/wallet/register"
        );

    }

    @Bean
    public List<String> customerPermissions() {

        return List.of(
                "TRANSFER_MONEY",
                "VIEW_BALANCE",
                "VIEW_PROFILE"
        );

    }

    @Bean
    public List<String> adminPermissions() {

        return List.of(
                "TRANSFER_MONEY",
                "VIEW_BALANCE",
                "VIEW_PROFILE",
                "LOCK_ACCOUNT",
                "UNLOCK_ACCOUNT",
                "VIEW_REPORTS",
                "DELETE_ACCOUNT"
        );

    }

    public boolean hasPermission(String role,
                                 String permission) {

        if ("ADMIN".equalsIgnoreCase(role)) {

            return adminPermissions()
                    .contains(permission);

        }

        if ("CUSTOMER".equalsIgnoreCase(role)) {

            return customerPermissions()
                    .contains(permission);

        }

        return false;
    }

}
