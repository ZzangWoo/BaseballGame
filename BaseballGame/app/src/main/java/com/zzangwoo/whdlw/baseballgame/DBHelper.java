/*package com.example.whdlw.baseballgame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public  DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BASEBALL (_id INTEGER PRIMARY KEY AUTOINCREMENT, count INTEGER, time INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS BASEBALL");
        onCreate(db);
    }

    public void insert(int count, int time){
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO BASEBALL VALUES(null, '" + count + "', " + time + "');");
        db.close();
    }

    public void update(int count, int time){
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 가격 정보 수정
        db.execSQL("UPDATE BASEBALL SET count=" + count + " WHERE time='" + time + "';");
        db.close();
    }

    public void delete(int count){
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM BASEBALL WHERE count='" + count + "';");
        db.close();
    }


}
*/