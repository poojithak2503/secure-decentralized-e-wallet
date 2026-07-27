package com.poojitha.ewallet.repository;

import com.poojitha.ewallet.model.WalletUser;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class WalletRepository {

    private final Map<Long, WalletUser> database =
            new ConcurrentHashMap<>();

    public WalletUser save(WalletUser user) {

        database.put(user.getUserId(), user);

        return user;
    }

    public Optional<WalletUser> findById(Long id) {

        return Optional.ofNullable(database.get(id));
    }

    public List<WalletUser> findAll() {

        return new ArrayList<>(database.values());
    }

    public Optional<WalletUser> findByEmail(String email) {

        return database.values()
                .stream()
                .filter(user ->
                        user.getEmail()
                                .equalsIgnoreCase(email))
                .findFirst();
    }

    public void delete(Long id) {

        database.remove(id);

    }

    public long totalUsers() {

        return database.size();

    }

    public double totalBalance() {

        return database.values()
                .stream()
                .mapToDouble(WalletUser::getWalletBalance)
                .sum();
    }

}
