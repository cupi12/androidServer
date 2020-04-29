package com.example.edumng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txUserid = findViewById(R.id.txtUserid);
        TextView txUserpw = findViewById(R.id.txtUserpw);
        TextView txUsername = findViewById(R.id.txtUsername);
        Button btnManage = findViewById(R.id.btnmanage);

        Intent intent = getIntent();
        String userid = intent.getExtras().getString("userid");
        String userpw = intent.getExtras().getString("userpw");
        String username = intent.getExtras().getString("username");
        //수신 데이터를 view에 출력
        txUserid.setText(userid);
        txUserid.setText(userpw);
        txUserid.setText(username);

        //관리자가 아니면, 회원관리 버튼 안보이게
        if(! userid.equals("admin")){
            btnManage.setVisibility(View.GONE);
        }else{
            btnManage.setVisibility(View.VISIBLE);
        }
    }
}
