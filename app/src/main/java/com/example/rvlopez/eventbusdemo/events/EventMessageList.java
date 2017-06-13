package com.example.rvlopez.eventbusdemo.events;

import java.util.List;

public class EventMessageList {

    private final List<String> messageList;

    public EventMessageList(List<String> messageList) {
        this.messageList = messageList;;
    }

    public List<String> getMessageList() {
        return messageList;
    }
}
