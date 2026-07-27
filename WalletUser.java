package com.poojitha.ewallet.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class WalletUser {

    private Long userId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String walletId;
    private double walletBalance;
    private String role;
    private boolean accountLocked;
    private boolean mfaEnabled;
    private LocalDateTime createdDate;
    private LocalDateTime lastLogin;

    public WalletUser() {
    }

    public WalletUser(Long userId,
                      String fullName,
                      String email,
                      String mobileNumber,
                      String walletId,
                      double walletBalance,
                      String role) {

        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.walletId = walletId;
        this.walletBalance = walletBalance;
        this.role = role;
        this.accountLocked = false;
        this.mfaEnabled = true;
        this.createdDate = LocalDateTime.now();
        this.lastLogin = LocalDateTime.now();
    }

    public boolean hasSufficientBalance(double amount) {
        return walletBalance >= amount;
    }

    public void credit(double amount) {
        walletBalance += amount;
    }

    public void debit(double amount) {

        if (hasSufficientBalance(amount)) {
            walletBalance -= amount;
        }

    }

    public void lockAccount() {
        accountLocked = true;
    }

    public void unlockAccount() {
        accountLocked = false;
    }

    public void updateLoginTime() {
        lastLogin = LocalDateTime.now();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isMfaEnabled() {
        return mfaEnabled;
    }

    public void setMfaEnabled(boolean mfaEnabled) {
        this.mfaEnabled = mfaEnabled;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    @Override
    public String toString() {
        return "WalletUser{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", walletId='" + walletId + '\'' +
                ", walletBalance=" + walletBalance +
                ", role='" + role + '\'' +
                ", accountLocked=" + accountLocked +
                '}';
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof WalletUser)) {
            return false;
        }

        WalletUser user = (WalletUser) object;

        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}
