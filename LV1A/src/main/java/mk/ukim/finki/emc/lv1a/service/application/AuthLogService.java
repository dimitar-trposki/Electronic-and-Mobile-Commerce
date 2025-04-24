package mk.ukim.finki.emc.lv1a.service.application;

import mk.ukim.finki.emc.lv1a.dto.AuthLogDto;

import java.time.Instant;
import java.util.List;

public interface AuthLogService {
    void logToken(String username, String token, Instant issuedAt, Instant expiresAt);

    List<AuthLogDto> getAllLogs();
}
