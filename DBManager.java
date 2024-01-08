package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import android.widget.Toast;

public class DBManager {
    private SQLiteDatabase sqlDB;
    static final String DBName = "dbHealthness";
    static final int DBVersion = 1;

    static final String TABLE_USERS = "users";
    static final String COLUMN_ID = "id";
    static final String ColUsername = "username";
    static final String ColPassword = "password";

    static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ColUsername + " TEXT, " +
                    ColPassword + " TEXT)";



    static class DatabaseHelperUser extends SQLiteOpenHelper {
        Context context;

        DatabaseHelperUser(Context context) {
            super(context, DBName, null, DBVersion);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_USERS);

            Toast.makeText(context, "Table is created", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

            onCreate(db);
        }
    }

    public DBManager(Context context) {
        DatabaseHelperUser db = new DatabaseHelperUser(context);
        sqlDB = db.getWritableDatabase();
    }

    public long Insert(ContentValues values) {
        long ID = sqlDB.insert(TABLE_USERS, "", values);
        return ID;
    }


    public Cursor query(String[] Projection, String Selection, String[] SelectionArgs, String SortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_USERS);
        return qb.query(sqlDB, Projection, Selection, SelectionArgs, null, null, SortOrder);
    }
}
