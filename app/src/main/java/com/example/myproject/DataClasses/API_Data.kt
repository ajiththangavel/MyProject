package com.example.myproject.DataClasses

import android.os.Parcel
import android.os.Parcelable

// Define a data class DataClass implementing Parcelable interface to pass data between activities
data class API_Data(var title : String, var thumbnailUrl : String) : Parcelable {
    // Constructor for creating DataClass from Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString()!!, // Read title from Parcel
        parcel.readString()!!// Read thumbnailUrl from Parcel
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(thumbnailUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<API_Data> {
        override fun createFromParcel(parcel: Parcel): API_Data {
            return API_Data(parcel)
        }

        override fun newArray(size: Int): Array<API_Data?> {
            return arrayOfNulls(size)
        }
    }

}