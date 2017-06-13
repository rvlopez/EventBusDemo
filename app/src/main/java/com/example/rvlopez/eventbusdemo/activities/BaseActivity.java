package com.example.rvlopez.eventbusdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rvlopez.eventbusdemo.R;

import butterknife.BindView;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected boolean useToolbar() {
        return true;
    }

    public void initToolbar() {
        if (toolbar != null) {
            if (useToolbar()) {
                setSupportActionBar(toolbar);
                setTitle(R.string.add_new_message);
            } else {
                toolbar.setVisibility(View.GONE);
            }
        }
    }
}
