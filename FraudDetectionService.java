package com.poojitha.ewallet.service;

import com.poojitha.ewallet.model.WalletUser;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    public boolean validateTransaction(WalletUser sender,
                                       WalletUser receiver,
                                       double amount) {

        if (sender == null || receiver == null) {
            return false;
        }

        if (sender.isAccountLocked()) {
            return false;
        }

        if (receiver.isAccountLocked()) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }

        if (amount > 10000) {

            System.out.println(
                    "Large Transaction Detected");

        }

        if (!sender.hasSufficientBalance(amount)) {

            System.out.println(
                    "Insufficient Balance");

            return false;
        }

        return true;
    }

    public boolean detectSuspiciousLogin(int failedAttempts) {

        return failedAttempts >= 5;

    }

    public boolean verifyOtp(String otp) {

        return otp != null
                && otp.length() == 6;

    }

    public String riskLevel(double amount) {

        if (amount < 500) {
            return "LOW";
        }

        if (amount < 5000) {
            return "MEDIUM";
        }

        return "HIGH";
    }

}
