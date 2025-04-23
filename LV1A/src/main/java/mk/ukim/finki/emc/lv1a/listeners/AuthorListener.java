package mk.ukim.finki.emc.lv1a.listeners;

import jakarta.persistence.*;
import mk.ukim.finki.emc.lv1a.events.AuthorChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorListener {
    @PersistenceContext
    private EntityManager entityManager;

    @EventListener
    public void handleAuthorChange(AuthorChangedEvent event) {
        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW author_count_by_country")
                .executeUpdate();
    }
}
