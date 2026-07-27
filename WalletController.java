package com.poojitha.ewallet.controller;

import com.poojitha.ewallet.model.WalletUser;
import com.poojitha.ewallet.service.AuthenticationService;
import com.poojitha.ewallet.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final WalletService walletService;
    private final AuthenticationService authenticationService;

    public WalletController(WalletService walletService,
                            AuthenticationService authenticationService) {
        this.walletService = walletService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public WalletUser register(@RequestBody WalletUser user) {

        return walletService.registerUser(user);

    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        return authenticationService.authenticate(email, password);

    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long senderId,
                           @RequestParam Long receiverId,
                           @RequestParam double amount) {

        boolean success = walletService.transferMoney(
                senderId,
                receiverId,
                amount
        );

        if (success) {
            return "Money transferred successfully.";
        }

        return "Transfer failed.";
    }

    @GetMapping("/users")
    public List<WalletUser> users() {

        return walletService.getAllUsers();

    }

    @GetMapping("/{userId}")
    public Optional<WalletUser> getUser(
            @PathVariable Long userId) {

        return walletService.findUser(userId);

    }

    @PutMapping("/{userId}/lock")
    public String lock(@PathVariable Long userId) {

        walletService.lockWallet(userId);

        return "Wallet locked.";

    }

    @PutMapping("/{userId}/unlock")
    public String unlock(@PathVariable Long userId) {

        walletService.unlockWallet(userId);

        return "Wallet unlocked.";

    }

    @GetMapping("/report")
    public String report() {

        return walletService.walletReport();

    }

}
