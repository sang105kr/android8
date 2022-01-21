package com.kh.practice4_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    Button button;
    ImageView imageView;

    int degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setTitle("연습문제 4_9");

        button = findViewById(R.id.btn);
        imageView = findViewById(R.id.iv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degree += 10;
                imageView.setRotation(degree);
            }
        });
    }
}