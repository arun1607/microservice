package com.learning.handler;

import com.learning.event.Event;

/**
 * Created by amits on 28/09/15.
 */
public interface EventHandler {
    public void handleEvent(Event event);
}
