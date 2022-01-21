package com.kh.practice5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.ic_launcher_foreground);
        }

        setTitle("연습문제5-7");

        LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.VERTICAL);

        layout1.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,   //가로
                LinearLayout.LayoutParams.MATCH_PARENT    //세로
        ));
        layout1.setBackgroundColor(Color.GRAY);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,   //가로
                0    //세로
        );
        params1.weight = 1; //비중

        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        layout2.setLayoutParams(params1);
        layout2.setBackgroundColor(Color.RED);


        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                0,   //가로
                LinearLayout.LayoutParams.MATCH_PARENT    //세로
        );
        params2.weight = 1; //비중
        LinearLayout layout4 = new LinearLayout(this);
        layout4.setOrientation(LinearLayout.HORIZONTAL);
        layout4.setLayoutParams(params2);
        layout4.setBackgroundColor(Color.RED);

        LinearLayout layout5 = new LinearLayout(this);
        layout5.setOrientation(LinearLayout.VERTICAL);
        layout5.setLayoutParams(params2);
        layout5.setBackgroundColor(Color.GREEN);

        LinearLayout layout6 = new LinearLayout(this);
        layout6.setOrientation(LinearLayout.VERTICAL);
        layout6.setLayoutParams(params1);
        layout6.setBackgroundColor(Color.YELLOW);

        LinearLayout layout7 = new LinearLayout(this);
        layout7.setOrientation(LinearLayout.VERTICAL);
        layout7.setLayoutParams(params1);
        layout7.setBackgroundColor(Color.BLACK);

        LinearLayout layout3 = new LinearLayout(this);
        layout3.setOrientation(LinearLayout.HORIZONTAL);
        layout3.setLayoutParams(params1);
        layout3.setBackgroundColor(Color.BLUE);

        layout5.addView(layout6); layout5.addView(layout7);
        layout2.addView(layout4); layout2.addView(layout5);
        layout1.addView(layout2); layout1.addView(layout3);

        setContentView(layout1);
    }
}