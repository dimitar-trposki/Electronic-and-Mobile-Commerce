package mk.ukim.finki.emc.lv1b.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostDeletedEvent extends ApplicationEvent {

    private LocalDateTime now;

    public HostDeletedEvent(Object source) {
        super(source);
        this.now = LocalDateTime.now();
    }

    public HostDeletedEvent(Object source, LocalDateTime now) {
        super(source);
        this.now = now;
    }
}
