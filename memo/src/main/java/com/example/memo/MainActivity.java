package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnnewmemo = (Button)findViewById(R.id.btnnewmemo);
        Button btnselect = (Button)findViewById(R.id.btnsearch);
        btnnewmemo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                startActivity(intent);
            }//end of onClick
        });//end of btnnewmemo

        load_value();
    }//end of onCreate

    private void load_value(){
        ArrayList<HashMap<String, String>> list = new MemoDAO().selectAll(getApplicationContext());
        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this, //값을 넘겨줌,
                        list,  //Model(data)
                        android.R.layout.simple_list_item_2, //String값을 2개 뿌릴 수 있는 하나의 list item (View)
                        new String[]{"title", "content"}, //
                        new int[]{android.R.id.text1, android.R.id.text2}); // 뿌릴 String 값 2개 지정
        // ListView에 adapter 연결
        ListView listView = findViewById(R.id.lvMemo);
        listView.setAdapter(simpleAdapter);
    }//end of load_value


}//end of MainActivity
