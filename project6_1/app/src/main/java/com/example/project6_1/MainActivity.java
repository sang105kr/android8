package com.example.project6_1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private LinearLayout linearLayout;
    private FrameLayout frameLayout;
    private Button btnStart, btnEnd;    //예약 시작, 예약 종료
    private RadioButton rdoCal;
    private RadioButton rdoTime;
    private CalendarView calendarView;
    private TimePicker timePicker;
    private TextView tvYear;
    private TextView tvMonth;
    private TextView tvDay;
    private TextView tvHour;
    private TextView tvMinute;
    private Chronometer chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간예약");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.ic_launcher_foreground);
        }

        //view 참조해오기
        chrono = findViewById(R.id.chrono);
        btnStart = findViewById(R.id.btnStart);

        linearLayout = findViewById(R.id.linerlayout);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);

        frameLayout = findViewById(R.id.frameLayout);
        calendarView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);

        btnEnd = findViewById(R.id.btnEnd);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        //예약일, 얘약시간 버튼 감추기
        linearLayout.setVisibility(View.INVISIBLE);
        //캘린더뷰, 타임피커 감추기
        frameLayout.setVisibility(View.INVISIBLE);

        //예약시작
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startReservation();
            }
        });

        //예약종료
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endReservation();
            }
        });

    }
    private void startReservation(){
        //1) 크로노미터 동작시작
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();
        chrono.setTextColor(Color.RED);

        //2) 예약일 , 예약시간 라디오버튼 보이도록
        linearLayout.setVisibility(View.VISIBLE);

        //3) 예약일 , 예약시간 라디오버튼 리스너 등록
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });
    }
   private void endReservation(){

      chrono.stop();
   }
}