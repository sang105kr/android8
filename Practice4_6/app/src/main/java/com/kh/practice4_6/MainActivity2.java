package com.kh.practice4_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity2 extends AppCompatActivity {

    CheckBox checkBox[] = new CheckBox[3];
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("연습문제 4_7");

        checkBox[0] = findViewById(R.id.cb1);
        checkBox[1] = findViewById(R.id.cb2);
        checkBox[2] = findViewById(R.id.cb3);

        button = findViewById(R.id.btn);

        //버튼 활성 비활성
        checkBox[0].setOnCheckedChangeListener((compoundButton, b) -> {
            if( b ){
                button.setEnabled(true);
            }else{
                button.setEnabled(false);
            }
        });

        //버튼 클릭가능 불가능
        checkBox[1].setOnCheckedChangeListener((compoundButton, b) -> {
            if( b ){
                button.setClickable(true);
            }else{
                button.setClickable(false);
            }
        });

        //버튼 45도 회전 비회전
        checkBox[2].setOnCheckedChangeListener((compoundButton, b) -> {
            if( b ){
                button.setRotation(45.0f);
            }else{
                button.setRotation(0.0f);
            }
        });
    }
}