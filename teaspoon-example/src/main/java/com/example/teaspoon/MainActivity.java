package com.example.teaspoon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import teaspoon.annotations.OnBackground;
import teaspoon.annotations.OnUi;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnSleepOnBackground;
    Button btnSleepOnUi;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSleepOnBackground = (Button) findViewById(R.id.main_btn_sleep_on_background);
        btnSleepOnUi = (Button) findViewById(R.id.main_btn_sleep_on_ui);

        attachClickListener();
    }

    private void attachClickListener() {
        btnSleepOnBackground.setOnClickListener(this);
        btnSleepOnUi.setOnClickListener(this);
    }

    @OnBackground private void sleepOnBackgroundThread() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @OnUi private void sleepOnUiThread() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override public void onClick(View v) {
        final int id = v.getId();

        switch(id) {
            case R.id.main_btn_sleep_on_background:
                sleepOnBackgroundThread();
                break;
            case R.id.main_btn_sleep_on_ui:
                sleepOnUiThread();
                break;
        }
    }
}
