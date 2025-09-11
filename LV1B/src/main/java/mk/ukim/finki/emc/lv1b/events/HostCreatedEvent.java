package mk.ukim.finki.emc.lv1b.events;

import lombok.Getter;
import mk.ukim.finki.emc.lv1b.model.domain.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public HostCreatedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public HostCreatedEvent(Object source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
