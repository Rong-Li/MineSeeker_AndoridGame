package com.example.lirongl.mineseekergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons();
    }//end of onCreate!!!!!!!!

    private void setButtons() {
        //btn1 ==== play
        //btn2 ==== options
        //btn3 ==== help
        Button btn1 = (Button) findViewById(R.id.playButtonID);
        Button btn2 = (Button) findViewById(R.id.optionsButtonID);
        Button btn3 = (Button) findViewById(R.id.helpButtonID);

        //set these three buttons
        //btn1 btn1 btn1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launching GameActivity
                Intent intent1 = GameActivity.newIntent(MainActivity.this);
                startActivity(intent1);
            }
        });
        //btn2 btn2 btn2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lauching OptionsActivity
                Intent intent2 = OptionsActivity.newIntent(MainActivity.this);
                startActivity(intent2);
            }
        });
        //btn3 btn3 btn3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = HelpActivity.newIntent(MainActivity.this);
                startActivity(intent3);
            }
        });
    }//end of ButtonsSettings!!!!!!!



}//end of MainActivity!!!!!!










