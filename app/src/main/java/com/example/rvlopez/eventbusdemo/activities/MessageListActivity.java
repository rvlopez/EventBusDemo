package com.example.rvlopez.eventbusdemo.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rvlopez.eventbusdemo.GlobalBus;
import com.example.rvlopez.eventbusdemo.R;
import com.example.rvlopez.eventbusdemo.adapters.MessageListAdapter;
import com.example.rvlopez.eventbusdemo.events.EventMessageList;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MessageListActivity extends BaseActivity {

    private List<String> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        initToolbar();
    }

    private void initRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MessageListAdapter messageListAdapter = new MessageListAdapter(messageList);
        recyclerView.setAdapter(messageListAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GlobalBus.getEventBus().register(this);
    }

    @Override
    protected void onStop() {
        GlobalBus.getEventBus().unregister(this);
        super.onStop();
    }

    @Subscribe(sticky = true)
    public void onMessageEvent(EventMessageList event) {
        messageList.addAll(event.getMessageList());
        initRecycler();
    }
}
