package com.caunk94.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        my_toolbar.setTitle(R.string.profile_title);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//untuk menampilkan back button ke main activity
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
