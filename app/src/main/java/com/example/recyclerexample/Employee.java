package com.example.recyclerexample;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "employee")
public class Employee implements Parcelable {


    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;

    /**
     * No args constructor for use in serialization
     *
     */

    @Ignore
    public Employee() {
    }

    /**
     *
     * @param name
     * @param id
     * @param age
     * @param vehicle
     */
    public Employee( Integer id, String name, Integer age, Vehicle vehicle) {
        super();

        this.id = id;
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }


    protected Employee(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            age = null;
        } else {
            age = in.readInt();
        }
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(id);
        parcel.writeInt(age);
        parcel.writeParcelable(vehicle,0);

    }


}
