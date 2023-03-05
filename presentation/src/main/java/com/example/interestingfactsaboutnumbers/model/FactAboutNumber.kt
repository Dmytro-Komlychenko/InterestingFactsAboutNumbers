package com.example.interestingfactsaboutnumbers.model

import android.os.Parcel
import android.os.Parcelable

data class FactAboutNumber(var number: Int, var fact: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeString(fact)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FactAboutNumber> {
        override fun createFromParcel(parcel: Parcel): FactAboutNumber {
            return FactAboutNumber(parcel)
        }

        override fun newArray(size: Int): Array<FactAboutNumber?> {
            return arrayOfNulls(size)
        }
    }
}