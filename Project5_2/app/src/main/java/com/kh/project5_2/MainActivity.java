package com.kh.project5_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 피연산자
    EditText edit1, edit2;
    // 0~9버튼
    Button[] btnsOfNum = new Button[10];
    int[] numBtnIds = {
            R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
            R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9,
    };
    // 4칙연산 : + - * /
    Button[] btnsOfOperand = new Button[4];
    // 계산결과
    TextView result;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.ic_launcher_foreground);
        }

        setTitle("테이블 레이아웃 계산기");

        // 피연산자참조
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        edit1.setInputType(0);
        edit2.setInputType(0);

        // 0~9버튼 참조
        for(int i=0; i<btnsOfNum.length; i++){
            btnsOfNum[i] = findViewById(numBtnIds[i]);
            int finalI = i;
            btnsOfNum[i].setOnClickListener(view -> {
                //포커스된 에디트텍스트에 숫자 추가
                if(edit1.isFocused()){
                    String text = edit1.getText().toString() + btnsOfNum[finalI].getText().toString();
                    edit1.setText(text);
                }else if(edit2.isFocused()){
                    String text = edit2.getText().toString() + btnsOfNum[finalI].getText().toString();
                    edit2.setText(text);
                }else {
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // 사칙연산 버튼 참조
        btnsOfOperand[0] = findViewById(R.id.BtnAdd);
        btnsOfOperand[1] = findViewById(R.id.BtnSub);
        btnsOfOperand[2] = findViewById(R.id.BtnMul);
        btnsOfOperand[3] = findViewById(R.id.BtnDiv);


        // 계산 결과 참조
        result = findViewById(R.id.TextResult);

        btnsOfOperand[0].setOnTouchListener((view, motionEvent) -> {

            if (MainActivity.this.validateChk()) return false;

            int tmp = Integer.parseInt(edit1.getText().toString()) + Integer.parseInt(edit2.getText().toString());
            String str = MainActivity.this.getString(R.string.result) + tmp;
            result.setText(str);

            MainActivity.this.setEditTextFocusClear();
            view.performClick();

            return true;
        });


        btnsOfOperand[1].setOnTouchListener((view, motionEvent) -> {

            if (validateChk()) return false;

            int tmp = Integer.parseInt(edit1.getText().toString()) - Integer.parseInt(edit2.getText().toString());
            String str = getString(R.string.result) + tmp;
            result.setText(str);

            setEditTextFocusClear();

            return true;
        });


        btnsOfOperand[2].setOnTouchListener((view, motionEvent) -> {

            if (validateChk()) return false;

            int tmp = Integer.parseInt(edit1.getText().toString()) * Integer.parseInt(edit2.getText().toString());
            String str = getString(R.string.result) + tmp;
            result.setText(str);

            setEditTextFocusClear();

            return true;
        });


        btnsOfOperand[3].setOnTouchListener((view, motionEvent) -> {

            if (validateChk()) return false;

            double tmp = Integer.parseInt(edit1.getText().toString()) / (double)Integer.parseInt(edit2.getText().toString());
            String text = R.string.result + String.valueOf(tmp);
            result.setText(text);

            setEditTextFocusClear();

            return true;
        });

    }

    //포커스 해제
    private void setEditTextFocusClear() {
        edit1.clearFocus(); 
        edit2.clearFocus();
    }

    //피연산자 필수입력 체크
    private boolean validateChk() {
        if(edit1.getText().toString().trim().length() == 0 ){
            Toast.makeText(getApplicationContext(), "계산할 숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
            edit1.requestFocus();
            return true;
        }
        if(edit2.getText().toString().trim().length() == 0 ){
            Toast.makeText(getApplicationContext(), "계산할 숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
            edit2.requestFocus();
            return true;
        }
        return false;
    }
}