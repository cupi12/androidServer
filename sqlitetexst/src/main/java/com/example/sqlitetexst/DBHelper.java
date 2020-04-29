package com.example.sqlitetexst;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public DBHelper(Context context){
        super(context, "contact.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL= "CREATE TABLE IF NOT EXISTS CONTACT_T (" +
                "_NO "           + "INTEGER NOT NULL," +
                "NAME "         + "TEXT," +
                "PHONE "        + "TEXT," +
                "OVER20 "       + "INTEGER" + ")" ;
        db.execSQL(createSQL);

        db.execSQL("insert into  CONTACT_T values(100,'홍길동','010-1234',1)");
        db.execSQL("insert into  CONTACT_T values(102,'나기자','010-7894',0)");
        db.execSQL("insert into  CONTACT_T values(103,'김유신','010-1472',2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion!=DATABASE_VERSION){ //
            db.execSQL("drop table CONTACT_T");
            onCreate(db);
        }
    }
}