package com.example.sqlitetexst;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDAO {
    DBHelper dbHelper = null;

    //목록조회
    public ArrayList<HashMap<String, String>> selectAll(Context context){ //Context = 지금 실행중인 앱

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        dbHelper = new DBHelper(context);
        SQLiteDatabase db=dbHelper.getReadableDatabase(); //db open & connect db연결
        String sql = "select _no, name, phone, over20 from CONTACT_T order by _no ";
        Cursor cursor=db.rawQuery(sql, null); //sql구문 실행
        while (cursor.moveToNext()){ //결과 처리(Resultset)를 list에 담음
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("_no", cursor.getString(0));
            map.put("name", cursor.getString(1));
            map.put("phone", cursor.getString(2));
            map.put("over20", cursor.getString(3));
            list.add(map);
        }
        dbHelper.close(); //DB연결 해제
        return list;
    }
    //등록
    public void insert(Context context, ContactVO vo){
        dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sqlInsert = "INSERT INTO CONTACT_T " +
                "(_NO, NAME, PHONE, OVER20) VALUES (" +
                vo.get_no() + "," +
                "'" + vo.getName() + "'," +
                "'" + vo.getPhone() + "'," +
                vo.getOver20() + ")" ;

        db.execSQL(sqlInsert);
        dbHelper.close();
    }
    //수정

    //삭제

    //단건조회
}
