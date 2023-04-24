package com.example.login_signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.nio.file.attribute.UserPrincipal;

public class dbHandler extends SQLiteOpenHelper {
    public dbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table User (name TEXT,email TEXT,password TEXT,phn TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("drop table if exists User");
    }

    public Boolean addUser(user u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", u.getName());
        values.put("email", u.getEmail());
        values.put("password", u.getPass());
        values.put("phn", u.getPhone());
        long k = db.insert("User", null, values);
        if(k==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from User where email=?",new String[]{email});
        if (c.getCount()>0) {
          return true;
        } else {
            return false;
        }


    }
    public Boolean chkemailpass(String email,String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from User where email=? and password=?",new String[]{email,pass});
        if (c.getCount()>0) {
            return true;
        } else {
            return false;
        }

    }

    public Cursor getdet(String mail)
    {
        String name="Not found";
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select name from User where email="+mail,null);

    }


}
