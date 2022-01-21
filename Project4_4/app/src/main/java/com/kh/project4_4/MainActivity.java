package com.kh.project4_4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Switch bntSwitch;
    ViewGroup linearLayout;
    Button[] buttons = new Button[2];
    RadioGroup radioGroup;
    ImageView imageView;
    RadioButton[] radioButtons = new RadioButton[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앱 아이콘
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setIcon(R.drawable.ic_launcher);

        //앱 타이틀
        setTitle("안드로이드 사진보기");

        //뷰 참조해오기
        bntSwitch = findViewById(R.id.btnSwitch);
        linearLayout = findViewById(R.id.con1);
        buttons[0] = findViewById(R.id.btnFinish);
        buttons[1] = findViewById(R.id.btnStart);

        radioGroup = findViewById(R.id.rg);
        imageView = findViewById(R.id.iv);

        radioButtons[0] = findViewById(R.id.BtnR1);
        radioButtons[1] = findViewById(R.id.BtnR2);
        radioButtons[2] = findViewById(R.id.BtnR3);

        //이벤트 리스너 등록 및 핸들러 구현
        bntSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            Log.d(TAG, compoundButton.toString());

            //체크 했을경우
            if (bntSwitch.isChecked()) {
                linearLayout.setVisibility(View.VISIBLE);

                //체크하지 않을경우
            } else {
                linearLayout.setVisibility(View.INVISIBLE);
                //라디오버튼 unchecked로 초기화
                for (RadioButton rb : radioButtons) {
                    if (rb.isChecked()) {
                        rb.setChecked(false);
                    }
                }
            }
        });

        radioButtons[0].setOnClickListener(view -> imageView.setImageResource(R.drawable.pie));
        radioButtons[1].setOnClickListener(view -> imageView.setImageResource(R.drawable.q10));
        radioButtons[2].setOnClickListener(view -> imageView.setImageResource(R.drawable.r11));

        //종료버튼
        buttons[0].setOnClickListener( view-> finish() );

        //시작버튼
        buttons[1].setOnClickListener( view -> {
            linearLayout.setVisibility(View.INVISIBLE);
            bntSwitch.setChecked(false);
        });
    }
}