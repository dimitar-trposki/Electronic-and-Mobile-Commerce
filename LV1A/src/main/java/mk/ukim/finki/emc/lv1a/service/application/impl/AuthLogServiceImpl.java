package mk.ukim.finki.emc.lv1a.service.application.impl;

import mk.ukim.finki.emc.lv1a.dto.AuthLogDto;
import mk.ukim.finki.emc.lv1a.service.application.AuthLogService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthLogServiceImpl implements AuthLogService {
    private final List<AuthLogDto> authLogs = new ArrayList<>();

    public void logToken(String username, String token, Instant issuedAt, Instant expiresAt) {
        authLogs.add(new AuthLogDto(username, token, issuedAt, expiresAt));
    }

    public List<AuthLogDto> getAllLogs() {
        return authLogs;
    }
}
