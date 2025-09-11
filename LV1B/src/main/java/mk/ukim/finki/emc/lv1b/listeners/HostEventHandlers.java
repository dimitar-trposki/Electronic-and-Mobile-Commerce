package mk.ukim.finki.emc.lv1b.listeners;

import mk.ukim.finki.emc.lv1b.events.HostChangedEvent;
import mk.ukim.finki.emc.lv1b.events.HostCreatedEvent;
import mk.ukim.finki.emc.lv1b.events.HostDeletedEvent;
import mk.ukim.finki.emc.lv1b.service.domain.HostService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostEventHandlers {

    private final HostService hostService;

    public HostEventHandlers(HostService hostService) {
        this.hostService = hostService;
    }

    @EventListener
    public void onHostCreated(HostCreatedEvent hostCreatedEvent){
        this.hostService.refreshMaterializedView();
    }

    @EventListener
    public void onHostChanged(HostChangedEvent hostChangedEvent){
        this.hostService.refreshMaterializedView();
    }

    @EventListener
    public void onHostDeleted(HostDeletedEvent hostDeletedEvent){
        this.hostService.refreshMaterializedView();
    }

}
