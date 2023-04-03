package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoa3,rdoa4,rdoa5;
    Button btnend,btnfirst,btncount,btnrotate;
    Integer count=0,degree=0;
    ImageView imgCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("아우아우디");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        text2 = (TextView) findViewById(R.id.Text2);
        rdoa3 = (RadioButton) findViewById(R.id.Rdoa3);
        rdoa4 = (RadioButton) findViewById(R.id.Rdoa4);
        rdoa5 = (RadioButton) findViewById(R.id.Rdoa5);
        imgCar = (ImageView) findViewById(R.id.imgCar);
        btnend = (Button) findViewById(R.id.btnend);
        btnfirst = (Button) findViewById(R.id.btnfirst);
        btncount = (Button) findViewById(R.id.btncount);
        btnrotate = (Button) findViewById(R.id.btnrotate);
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgCar.setVisibility(View.VISIBLE);
                    btnend.setVisibility(View.VISIBLE);
                    btnfirst.setVisibility(View.VISIBLE);
                    btncount.setVisibility(View.VISIBLE);
                }else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgCar.setVisibility(View.INVISIBLE);
                    btnend.setVisibility(View.INVISIBLE);
                    btnfirst.setVisibility(View.INVISIBLE);
                    btncount.setVisibility(View.INVISIBLE);
                }
            }
        });
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.Rdoa3:
                        imgCar.setImageResource(R.drawable.a3);
                        break;
                    case R.id.Rdoa4:
                        imgCar.setImageResource(R.drawable.a4);
                        break;
                    case R.id.Rdoa5:
                        imgCar.setImageResource(R.drawable.a5);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "차 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkAgree.setChecked(false);
                rdoa3.setChecked(false);
                rdoa4.setChecked(false);
                rdoa5.setChecked(false);
                imgCar.setImageResource(0);
                count=0;
            }
        });
        btncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if(count>=10 && count<20){
                    imgCar.setImageResource(R.drawable.a3);
                }else if(count>=20 && count <30){
                    imgCar.setImageResource(R.drawable.a4);
                }else{
                    imgCar.setImageResource(R.drawable.a5);
                }
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degree+=45;
                imgCar.setRotation(degree);
            }
        });
        imgCar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                degree+=45;
                imgCar.setRotation(degree);
                if(degree == 360){
                    degree=0;
                }
                return false;
            }
        });
    }
}