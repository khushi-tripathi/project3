package com.gdg.bhopal.project3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Db_helper extends SQLiteOpenHelper {
    static String DB_Name = "CollegeForm.db";
    static int DB_Version = 1;

    public  static  String Table_Name="clgForm";
    public static  String ID_COL ="ID";
    public  static String NAME_COL="NAME";
    public  static  String AGE_COL="AGE";
    public static String EMAIL_COL ="EMAIL";
    public  static  String PWD_COL="PASSWORD";
    public static String GENDER_COL="GENDER";
    public static String ADDRESS_COL="ADDRESS";
    public static String COURSE_COL="COURSE";
    public static String DOB_COL="DOB";
    public static String SCL_NAME_COL="SCHOOL";
    public static String MNO_COL="MOBILE NO.";

    public static String query= "create table "+Table_Name+"("+ID_COL +
            " integer primary key autoincrement, "+NAME_COL+" text, " +
            ""+AGE_COL+" integer, "+EMAIL_COL+" text" +
            ", "+PWD_COL+" text, "+GENDER_COL+" text, "+COURSE_COL+" text, "+DOB_COL+" text , "+MNO_COL+" text , "+SCL_NAME_COL+" text , "+ADDRESS_COL+" text)";

    public Db_helper(Context context){
        super(context,DB_Name,null,DB_Version);
    }

    public boolean insertForm(ClgForm cf){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(NAME_COL, cf.name);
            cv.put(AGE_COL, cf.age);
            cv.put(EMAIL_COL, cf.email);
            cv.put( PWD_COL,cf.pwd);
            cv.put(GENDER_COL,cf.gender);
            cv.put(ADDRESS_COL,cf.address);
            cv.put(COURSE_COL,cf.course);
            cv.put(DOB_COL,cf.dob);
            cv.put(SCL_NAME_COL,cf.school);
            cv.put(MNO_COL,cf.mob);
            db.insert(Table_Name, null, cv);
        }catch (Exception ex){
            return false;
        }
        return  true;
    }

    public ArrayList<ClgForm> getAllForm(){
        ArrayList<ClgForm> gList = new ArrayList<ClgForm>();
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c =db.rawQuery("SELECT * FROM "+Table_Name,null);
            while (c.moveToNext()) {
                String name = c.getString(c.getColumnIndex(NAME_COL));
                int age = c.getInt(c.getColumnIndex(AGE_COL));
                String email = c.getString(c.getColumnIndex(EMAIL_COL));
                String pwd = c.getString(c.getColumnIndex(PWD_COL));
                String dob = c.getString(c.getColumnIndex(DOB_COL));
                String address = c.getString(c.getColumnIndex(ADDRESS_COL));
                String mob = c.getString(c.getColumnIndex(MNO_COL));
                String course = c.getString(c.getColumnIndex(COURSE_COL));
                String school = c.getString(c.getColumnIndex(SCL_NAME_COL));
                String gender=c.getString(c.getColumnIndex(GENDER_COL));
                ClgForm form = new ClgForm(name,email,pwd,dob,address,mob,course,school,gender,age);
                gList.add(form);
            }
        }catch(Exception ex){
            Log.e("ERROR",ex.toString());
        }
        return gList;



    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(query);
        }catch (Exception e){
            Log.e("ERRORR",e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
