package com.example.project6_1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
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

      //액션바 설정
      makeActionBar();

      //view 참조해오기
      referenceOfView();

      //이벤트등록
      registerEvents();

      //화면 초기화
      initActivity();

    }

  //화면 초기화
  private void initActivity() {
    //예약일, 얘약시간 버튼 감추기
    linearLayout.setVisibility(View.INVISIBLE);
    //캘린더뷰, 타임피커 감추기
    frameLayout.setVisibility(View.INVISIBLE);
    //예약종료 비활성화
    btnEnd.setEnabled(false);
  }

  //이벤트 등록
  private void registerEvents() {
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

    //캘린더 날짜반영 - 예약일
    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
      @Override
      public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
        tvYear.setText(String.valueOf(i));
        tvMonth.setText(String.valueOf(i1+1)); // 월은 0~11 을 반환해옮
        tvDay.setText(String.valueOf(i2));
      }
    });

    //타임피커 시간반영 - 예약시간
    timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
      @Override
      public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        tvHour.setText(String.valueOf(i));      //시
        tvMinute.setText(String.valueOf(i1));   //분
      }
    });

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

  //뷰참조
  private void referenceOfView() {
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
  }

  //액션바 설정
  private void makeActionBar() {
    setTitle("시간예약");

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_launcher_foreground);
    }
  }

  //예약 시작
  private void startReservation(){
        //1) 크로노미터 동작시작
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();
        chrono.setTextColor(Color.RED);

        //2) 예약일 , 예약시간 라디오버튼 보이도록
        linearLayout.setVisibility(View.VISIBLE);


        //4) 예약종료 활성화
      btnEnd.setEnabled(true);

      initDateTime();

    }

  //예약일시 초기화
  private void initDateTime() {
    tvYear.setText("0000");
    tvMonth.setText("00");
    tvDay.setText("00");
    tvHour.setText("00");
    tvMinute.setText("00");
  }

  //예약 종료
  private void endReservation(){
     //예약일 미지정  체크
     if(tvDay.getText().toString().equals("00")){
       showToast("예약일을 입력바랍니다.");
       return;
     }
     //예약시간 미지정  체크
     if(tvMinute.getText().toString().equals("00")){
       showToast("예약시간을 입력바랍니다.");
       return;
     }

     chrono.stop();

     rdoCal.setChecked(false);
     rdoTime.setChecked(false);

     btnEnd.setEnabled(false);

     linearLayout.setVisibility(View.INVISIBLE);
     frameLayout.setVisibility(View.INVISIBLE);
   }

  //토스트 띄우기
  private void showToast(String msg){
    Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_SHORT).show();
  }

}