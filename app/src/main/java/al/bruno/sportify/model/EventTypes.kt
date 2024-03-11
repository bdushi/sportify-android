package al.bruno.sportify.model

import android.os.Parcel
import android.os.Parcelable

data class EventTypes (
        val id:Long,
        val types: String,
        val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString().toString(),
            parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(types)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventTypes> {
        override fun createFromParcel(parcel: Parcel): EventTypes {
            return EventTypes(parcel)
        }

        override fun newArray(size: Int): Array<EventTypes?> {
            return arrayOfNulls(size)
        }
    }

}