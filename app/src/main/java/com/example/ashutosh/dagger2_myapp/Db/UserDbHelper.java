package com.example.ashutosh.dagger2_myapp.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.ashutosh.dagger2_myapp.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ashutosh on 12/1/16.
 */
public class UserDbHelper extends SQLiteOpenHelper implements BaseColumns, ModelBasedDbHelperTemplate<UserModel> {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ACTIVITY_LOG_SAVED_SEARCHES_DB";

    private static final String TABLE_NAME = "ACTIVITY_LOG_SAVED_SEARCHES_TABLE";
    public static final String USERNAME = "USERNAME";
    public static final String EMAIL = "EMAIL" ;
    public static final String PASSWORD = "PASSWORD";

    private final ContentValues contentValues;

    @Inject
    public UserDbHelper(Context context, ContentValues contentValues) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.contentValues = contentValues;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME
                + "("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT NOT NULL UNIQUE, "
                + EMAIL + " TEXT NOT NULL UNIQUE, "
                + PASSWORD +" TEXT, "
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void insertData(UserModel userModel) {
        contentValues.clear();
        contentValues.put(USERNAME, userModel.getUserName());
        contentValues.put(PASSWORD, userModel.getPassword());
        contentValues.put(EMAIL, userModel.getEmailAddress());

        SQLiteDatabase db = getWritableDatabase();
        db.insertWithOnConflict(TABLE_NAME, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    @Override
    public UserModel getData(String username) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{USERNAME, EMAIL, PASSWORD},
                USERNAME + " = ?",
                new String[]{username},
                null,
                null,
                null
        );
        List<UserModel> userModelList = getData(cursor);
        cursor.close();
        return userModelList.get(0);
    }

    @Override
    public void removeData(String username) {

    }

    @Override
    public List<UserModel> getCompleteData() {
        return null;
    }

    @Override
    public List<UserModel> getData(Cursor cursor) {
        List<UserModel> ret = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String username = cursor.getString(cursor.getColumnIndex(USERNAME));
                String email = cursor.getString(cursor.getColumnIndex(EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(PASSWORD));
                ret.add(new UserModel(username, email, password));
            }
        }
        return ret;
    }

    @Override
    public int getTotalRows() {
        return 0;
    }

    @Override
    public boolean isPresent(String username) {
        Cursor cursor = getWritableDatabase().rawQuery(
                "select 1 from " + TABLE_NAME + " where " + USERNAME + " = %s ",
                new String[] {username}
        );
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
}
