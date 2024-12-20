package org.jb10pigeonskyracesecurity.events;

import lombok.Getter;
import org.jb10pigeonskyracesecurity.dtos.RaceDTO;
import org.springframework.context.ApplicationEvent;

@Getter
public class RaceClosedEvent extends ApplicationEvent {
    private final RaceDTO race;
    public RaceClosedEvent(Object source, RaceDTO race) {
        super(source);
        this.race = race;
    }
}
