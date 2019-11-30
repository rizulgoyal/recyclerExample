package com.example.recyclerexample;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle implements Parcelable {

    @SerializedName("@class")
    @Expose
    private String _class;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("plate")
    @Expose
    private String plate;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("insurance")
    @Expose
    private Boolean insurance;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public Vehicle() {
    }

    /**
     *
     * @param insurance
     * @param plate
     * @param model
     * @param _class
     * @param id
     * @param type
     * @param make
     */
    public Vehicle(String _class, Integer id, String make, String plate, String model, Boolean insurance, String type) {
        super();
        this._class = _class;
        this.id = id;
        this.make = make;
        this.plate = plate;
        this.model = model;
        this.insurance = insurance;
        this.type = type;
    }

    protected Vehicle(Parcel in) {
        _class = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        make = in.readString();
        plate = in.readString();
        model = in.readString();
        byte tmpInsurance = in.readByte();
        insurance = tmpInsurance == 0 ? null : tmpInsurance == 1;
        type = in.readString();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_class);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(make);
        parcel.writeString(plate);
        parcel.writeString(model);
        parcel.writeByte((byte) (insurance == null ? 0 : insurance ? 1 : 2));
        parcel.writeString(type);
    }
}
