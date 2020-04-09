package com.example.newsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
    private final DatabaseHelper mHelper;
    private String TAG = "Dao" ;
    private Context context;
    public Dao(Context context) {
        //创建数据库
        this.context = context;
        mHelper = new DatabaseHelper(context);
    }

    public void insert() {
        SQLiteDatabase db = mHelper.getWritableDatabase();
/*        String sql = "insert into " + Constants.TABLE_NAME+ "(_id,name,age,salary,phone,adress) values(?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{1,"BillGates",60,1, 110, "USA"});*/

        //谷歌api 操作，因为db.insert最后参数为 第一个是表名 第二个是如果你插入数据为空时，就会将你指定的这个列名的值设为null，然后再向数据库中插入 ContentValues所以创建一个给他
        ContentValues values = new ContentValues();
        values.put("id",3);
        values.put("newsTitle",789);
        values.put("newsContent","USA where 3");
        db.insert(Constants.TABLE_NAME,null,values);
        db.close();
    }

    public void delete() {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql = "delete from " + Constants.TABLE_NAME + " where age = 60";
        db.execSQL(sql);*/

        int result = db.delete(Constants.TABLE_NAME,null,null);
        Log.d(TAG,"delete_result ==="+result);

        db.close();
    }

    public void update() {
        SQLiteDatabase db = mHelper.getWritableDatabase();
  /*      String sql = "update " + Constants.TABLE_NAME + " set salary =2 where age =60";
        db.execSQL(sql);*/
        //谷歌api
        ContentValues values =new ContentValues();
        values.put("phone",123456789);
        db.update(Constants.TABLE_NAME,values,null,null);
        db.close();
    }

    public List<NewsBean> query() {
        List<NewsBean> list =new ArrayList<>();
        SQLiteDatabase db = mHelper.getWritableDatabase();
       /* String sql = "select * from " + Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        //是否有下一个  isFirst是否是第一个，move第几个 moveToLast最后一个
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("name");
            String name = cursor.getString(index);
            Log.d(TAG,"name == "+name);
        }
        cursor.close();*/
       //第一个表名 ,不分组，不排序，不要限制条件,所以后面全部添null
        Cursor cursor =db.query(Constants.TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()){

            String title = cursor.getString(1);
            String content = cursor.getString(2);
            list.add(new NewsBean(title,content));
        }
        cursor.close();
        db.close();
        return list;
    }
}
