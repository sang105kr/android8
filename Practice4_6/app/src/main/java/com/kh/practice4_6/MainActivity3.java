package com.kh.practice4_6;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("연습문제 4_8");

        editText = findViewById(R.id.et);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(keyEvent.getAction() == KeyEvent.ACTION_UP){
                    String str = editText.getText().toString();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }

                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(getApplicationContext(), "Enter 눌려짐", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }
}