package com.example.listviewclickarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_choose);

        Intent intent = getIntent();
        ((TextView)findViewById(R.id.tv_choose)).setText(intent.getStringExtra("fruit_name"));
    }
}
