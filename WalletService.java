package com.poojitha.ewallet.service;

import com.poojitha.ewallet.model.WalletUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final List<WalletUser> users = new ArrayList<>();

    public WalletUser registerUser(WalletUser user) {

        users.add(user);

        return user;
    }

    public boolean transferMoney(Long senderId,
                                 Long receiverId,
                                 double amount) {

        Optional<WalletUser> sender = findUser(senderId);
        Optional<WalletUser> receiver = findUser(receiverId);

        if (sender.isEmpty() || receiver.isEmpty()) {
            return false;
        }

        if (sender.get().isAccountLocked()) {
            return false;
        }

        if (!sender.get().hasSufficientBalance(amount)) {
            return false;
        }

        sender.get().debit(amount);
        receiver.get().credit(amount);

        return true;
    }

    public Optional<WalletUser> findUser(Long userId) {

        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();
    }

    public List<WalletUser> getAllUsers() {

        return new ArrayList<>(users);
    }

    public double totalWalletBalance() {

        return users.stream()
                .mapToDouble(WalletUser::getWalletBalance)
                .sum();
    }

    public Optional<WalletUser> richestUser() {

        return users.stream()
                .max(Comparator.comparingDouble(
                        WalletUser::getWalletBalance));
    }

    public void lockWallet(Long userId) {

        findUser(userId)
                .ifPresent(WalletUser::lockAccount);
    }

    public void unlockWallet(Long userId) {

        findUser(userId)
                .ifPresent(WalletUser::unlockAccount);
    }

    public long activeWallets() {

        return users.stream()
                .filter(user -> !user.isAccountLocked())
                .count();
    }

    public long lockedWallets() {

        return users.stream()
                .filter(WalletUser::isAccountLocked)
                .count();
    }

    public String walletReport() {

        StringBuilder report = new StringBuilder();

        report.append("Digital Wallet Report\n");
        report.append("-----------------------------\n");
        report.append("Generated : ")
                .append(LocalDateTime.now())
                .append("\n");

        report.append("Registered Users : ")
                .append(users.size())
                .append("\n");

        report.append("Active Wallets : ")
                .append(activeWallets())
                .append("\n");

        report.append("Locked Wallets : ")
                .append(lockedWallets())
                .append("\n");

        report.append("Total Balance : ")
                .append(totalWalletBalance())
                .append("\n");

        richestUser().ifPresent(user ->
                report.append("Highest Balance Holder : ")
                        .append(user.getFullName())
                        .append("\n"));

        return report.toString();
    }

}
