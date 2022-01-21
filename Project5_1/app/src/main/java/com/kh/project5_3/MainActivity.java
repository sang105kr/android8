package com.kh.project5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kh.project5_1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        EditText editText = new EditText(this);

        Button button = new Button(this);
        button.setText("버튼입니다");
        button.setBackgroundColor(Color.YELLOW);

        TextView textView = new TextView(this);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);

        button.setOnClickListener(view -> textView.setText(editText.getText().toString()));

        linearLayout.addView(editText);
        linearLayout.addView(button);
        linearLayout.addView(textView);



    }
}