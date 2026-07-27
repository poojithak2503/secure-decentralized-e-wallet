package com.poojitha.ewallet.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class RedisSessionService {

    private final Map<String, LocalDateTime> activeSessions =
            new HashMap<>();

    private final Map<String, Integer> requestCounter =
            new HashMap<>();

    public void createSession(String token) {

        activeSessions.put(
                token,
                LocalDateTime.now()
        );

    }

    public boolean isSessionActive(String token) {

        return activeSessions.containsKey(token);

    }

    public void removeSession(String token) {

        activeSessions.remove(token);

        requestCounter.remove(token);

    }

    public boolean allowRequest(String token) {

        int requests =
                requestCounter.getOrDefault(token, 0);

        if (requests >= 100) {
            return false;
        }

        requestCounter.put(token, requests + 1);

        return true;

    }

    public int activeSessionCount() {

        return activeSessions.size();

    }

    public void clearExpiredSessions() {

        Iterator<Map.Entry<String, LocalDateTime>> iterator =
                activeSessions.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, LocalDateTime> entry =
                    iterator.next();

            if (entry.getValue()
                    .isBefore(LocalDateTime.now().minusHours(2))) {

                requestCounter.remove(entry.getKey());

                iterator.remove();

            }

        }

    }

    public Map<String, LocalDateTime> getSessions() {

        return new HashMap<>(activeSessions);

    }

}
