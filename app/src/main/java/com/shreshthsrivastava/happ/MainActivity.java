package com.shreshthsrivastava.happ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent dashBoardIntent=new Intent(this,ListActivity.class);
        startActivity(dashBoardIntent);
        finish();
    }
}