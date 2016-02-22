package com.example.ashutosh.dagger2_myapp.Db;

import android.content.ContentUris;
import android.database.Cursor;

import java.util.List;

/**
 * Created by ashutosh on 12/1/16.
 */
public interface ModelBasedDbHelperTemplate<T> {
    void insertData(T t);
    T getData(String uniqueKey);
    void removeData(String uniqueKey);
    List<T> getCompleteData();
    List<T> getData(Cursor cursor);
    int getTotalRows();
    boolean isPresent(String uniqueKey);
}
