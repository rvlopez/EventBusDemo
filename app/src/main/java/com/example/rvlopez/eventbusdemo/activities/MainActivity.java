package com.example.rvlopez.eventbusdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rvlopez.eventbusdemo.GlobalBus;
import com.example.rvlopez.eventbusdemo.R;
import com.example.rvlopez.eventbusdemo.events.EventMessageList;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.message_field)
    EditText message;

    @BindView(R.id.go_to_list)
    Button toListBtn;

    private List<String> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initToolbar();
    }

    @OnClick(R.id.go_to_list)
    public void goToListActivity() {
        startActivity(new Intent(this, MessageListActivity.class));
        GlobalBus.getEventBus().postSticky(new EventMessageList(messageList));
    }

    @OnClick(R.id.send_button)
    public void submit() {
        if (isNotEmptyOrNullMessage()) {
            messageList.add(message.getText().toString());
            toListBtn.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), getString(R.string.message_added), Toast.LENGTH_SHORT).show();
            message.setText("");
        }
    }

    private boolean isNotEmptyOrNullMessage() {
        return (message != null && !message.getText().toString().isEmpty());
    }
}
