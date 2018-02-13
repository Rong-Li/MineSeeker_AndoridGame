package com.example.lirongl.mineseekergame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }//end of onCreate




    public static Intent newIntent(Context context) {
        return new Intent(context, HelpActivity.class);
    }

}//end of HelpActivity
