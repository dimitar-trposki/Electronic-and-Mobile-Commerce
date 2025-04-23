package mk.ukim.finki.emc.lv1a.events;

import org.springframework.context.ApplicationEvent;

public class AuthorChangedEvent extends ApplicationEvent {
    public AuthorChangedEvent(Object source) {
        super(source);
    }
}
