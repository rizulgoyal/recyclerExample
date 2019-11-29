package com.example.recyclerexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataAccessObjectInterface
{
    @Insert
    void insert(Employee employee);

    @Delete
    void delete(Employee employee);

    @Update
    void update(Employee employee);

    @Query("Select * from employee")
    LiveData<List<Employee>> getUserDetails();
    @Query("Select count(id) from employee")
    Integer count();
}