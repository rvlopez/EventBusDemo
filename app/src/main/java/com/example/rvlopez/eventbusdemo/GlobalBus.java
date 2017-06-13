package com.example.rvlopez.eventbusdemo;

import org.greenrobot.eventbus.EventBus;

public class GlobalBus {

    private static EventBus eventBus;

    public static EventBus getEventBus() {
        if (eventBus == null) {
            eventBus =  EventBus.getDefault();
        }
        return eventBus;
    }
}
