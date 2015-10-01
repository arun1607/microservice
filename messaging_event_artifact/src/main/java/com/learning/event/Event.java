package com.learning.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
@ToString
public class Event {

    private Long eventId;

    private EventType eventType;
}
