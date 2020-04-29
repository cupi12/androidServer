package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEmp = findViewById(R.id.btnEmp);
        btnEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EmpActivity.class);  //화면전환시 데이터 송수신
                startActivity(intent);
            }
        });
        Button btnDept = findViewById(R.id.btnDept);
        btnDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DeptActivity.class);  //화면전환시 데이터 송수신
                startActivity(intent);
            }
        });
    }
}
