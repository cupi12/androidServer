package com.example.memo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MemoDAO {
    DBHelper dbhelper;
    String tableName = "memo";

    //목록조회
    public ArrayList<HashMap<String, String>> selectAll(Context context){

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        dbhelper = new DBHelper(context);
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        String sql = "select _id, title, content, time from memo order by _id desc ";
        Cursor cursor=db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("_id", cursor.getString(0));
            map.put("title", cursor.getString(1));
            map.put("content", cursor.getString(2));
            map.put("time", cursor.getString(3));
            list.add(map);
        }
        dbhelper.close();
        System.out.print(list);
        return list;
    }
    //등록
    public void insert(Context context, MemoVO memo){
        dbhelper = new DBHelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
//        contentValues.put("_id", memo.get_id()); //자동 증가(autoincrement :자동시퀀스생성)면 넣을 필요 없고, 자동 증가면 넣어야함.
        contentValues.put("title", memo.getTitle());
        contentValues.put("content", memo.getContent());

        //현재시간 설정
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //SimpleDateFormat Date -> String타입으로 변환시켜줌
        String formatDate = sdfNow.format(mDate);
        contentValues.put("time", formatDate);

        db.insert(tableName, null, contentValues);
        dbhelper.close();
    }

    //수정
    public void update(Context context, MemoVO memo){
        dbhelper = new DBHelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();   //데이터베이스 연결

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", memo.getTitle());
        contentValues.put("content", memo.getContent());
        String id = Integer.toString(memo.get_id());
        db.update(tableName, contentValues, "_id=?", new String[]{id}) ;
        dbhelper.close();
//        update memo set title = ?, content=? where id = ?
    }

    //삭제
    public void delete(Context context, String id){
        dbhelper = new DBHelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.delete(tableName, "_id=?", new String[]{id}) ;
        dbhelper.close();
        //delete from memo where id=?
    }


    //단건조회
}
