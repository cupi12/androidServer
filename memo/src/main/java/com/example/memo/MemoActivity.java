package com.example.memo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        Button btninsert = (Button)findViewById(R.id.btninsert);
        btninsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                save_values();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }//end of onClick
        });//end of btninsert.setOnClick
    }//end of onCreate

    private void save_values(){
        EditText editTextTitle = (EditText) findViewById(R.id.editTitle);
        String title = editTextTitle.getText().toString();

        EditText editTextContent = (EditText) findViewById(R.id.editContent);
        String content = editTextContent.getText().toString();
        MemoVO vo = new MemoVO();
//                vo.set_id(Integer.parseInt());
        vo.setTitle(title);
        vo.setContent(content);

        new MemoDAO().insert(getApplicationContext(),vo);
        System.out.print(vo);

    }

//        private void load_value(){
//                            ArrayList<HashMap<String,String>> list = new MemoDAO().selectAll(getApplicationContext());
//                SimpleAdapter simpleAdapter =
//                        new SimpleAdapter(this,
//                                list,
//                                android.R.layout.simple_list_item_2,
//                                new String[]{"_id, title, content"},
//                                new int[]{android.R.id.text1, android.R.id.text2});
//                ListView listView = findViewById(R.id.);
//                listView.setAdapter(simpleAdapter);
//        }//end of load_value



}//end of MemoActivity
