package com.example.a15_sqlite_tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public
class SQLiteUserOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user1.db";
    private static final int DATABASE_VERSION = 1;

    public
    SQLiteUserOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public
    void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "msv TEXT," +
                "ten TEXT," +
                "lop TEXT," +
                "gioitinh TEXT," +
                "diemtoan INTEGER," +
                "diemly INTEGER," +
                "diemhoa INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public
    void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //add user
    public void addUser(User u){
        ContentValues values = new ContentValues();
        values.put("msv", u.getMaSinhVien());
        values.put("ten",u.getHoTen());
        values.put("lop", u.getLop());
        values.put("gioitinh", u.getGioiTinh());
        values.put("diemtoan", u.getDiemToan());
        values.put("diemly", u.getDiemLy());
        values.put("diemhoa", u.getDiemHoa());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("user", null, values);
    }

    //get all user
    public
    List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query("user", null, null, null, null, null, null, null);
        //di chuyển con trỏ lên đầu
        if(cursor !=null && cursor.moveToFirst()){
            do{
                String msv =cursor.getString(cursor.getColumnIndex("msv"));
                String ten = cursor.getString(cursor.getColumnIndex("ten"));
                String lop = cursor.getString(cursor.getColumnIndex("lop"));
                String gioitinh = cursor.getString(cursor.getColumnIndex("gioitinh"));
                String toan = cursor.getString(cursor.getColumnIndex("diemtoan"));
                String ly = cursor.getString(cursor.getColumnIndex("diemly"));
                String hoa = cursor.getString(cursor.getColumnIndex("diemhoa"));

                User u = new User(msv,ten,lop,gioitinh,toan,ly,hoa);
                list.add(u);
            }while (cursor.moveToNext()); // chuyển sang dòng tiếp theo)

        }
        return list;
    }
}
