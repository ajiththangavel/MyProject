package com.example.myproject

import android.os.Parcel
import android.os.Parcelable

// Define a data class DataClass implementing Parcelable interface to pass data between activities
data class DataClass(var title : String, var thumbnailUrl : String) : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<DataClass> {
        override fun createFromParcel(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }

        override fun newArray(size: Int): Array<DataClass?> {
            return arrayOfNulls(size)
        }
    }

}