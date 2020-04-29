package com.example.sqlitetexst;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class EmpDAO {

    Cursor cursor = null;
    DBHelper dbhelper = null;

    public  ArrayList<HashMap<String, String>>  selectAll(Context context){

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        dbhelper = new DBHelper(context);
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        String sql = "select _id, name, email, sal from CONTACT_T order by _id ";
        Cursor cursor=db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("_id", cursor.getString(0));
            map.put("name", cursor.getString(1));
            map.put("email", cursor.getString(2));
            map.put("sal", cursor.getString(3));
            list.add(map);
        }
        dbhelper.close();
        return list;
    }

    public  Cursor  selectCursor(Context context){

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        dbhelper = new DBHelper(context);
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        String sql = "select _id, name, email, sal from tb_emp order by _id ";
        Cursor cursor=db.rawQuery(sql, null);
        dbhelper.close();
        return cursor;
    }
}
