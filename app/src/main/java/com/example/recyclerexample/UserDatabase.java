package com.example.recyclerexample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = Employee.class , exportSchema = false , version = 2)
@TypeConverters({Converter.class})
public abstract class UserDatabase extends RoomDatabase
{

    public static final String DB_NAME = "user_db";

    private static  UserDatabase uInstance;


    public static UserDatabase getInstance(Context context)
    {
        if(uInstance == null)
        {
            uInstance = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,UserDatabase.DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return uInstance;
    }


    public abstract DataAccessObjectInterface daoObjct();
}
