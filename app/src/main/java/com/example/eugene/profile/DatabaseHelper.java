package com.example.eugene.profile;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore.db";
    private static final int SCHEMA = 1; //
    static final String TABLE = "users";
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_BORN_ON = "Born";
    public static final String COLUMN_FROM = "Fro";
    public static final String COLUMN_LOCATION = "Location";
    public static final String COLUMN_STUDIER_AT = "Studies";
    public static final String COLUMN_PHONE_NUMBER = "Phone";
    public static final String COLUMN_BIOGRAPHY = "Biography";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_BORN_ON +" TEXT, "+ COLUMN_FROM + " TEXT, "+ COLUMN_LOCATION + " TEXT, "+ COLUMN_STUDIER_AT + " TEXT, "+ COLUMN_PHONE_NUMBER + " TEXT, "+ COLUMN_BIOGRAPHY + " TEXT );" );
        // добавлення початкових даних
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME + " , " + COLUMN_BORN_ON  + " , " + COLUMN_FROM  + " , " + COLUMN_LOCATION  + "," + COLUMN_STUDIER_AT  + ", " + COLUMN_PHONE_NUMBER  + ", " + COLUMN_BIOGRAPHY  + ") " +
                "VALUES ('Віталік','30,03,1999','Чортків','Тернопіль','ТНТУ','0686256198','ТНТУ граю на нервах');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}