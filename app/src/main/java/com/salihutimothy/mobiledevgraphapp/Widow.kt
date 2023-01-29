package com.salihutimothy.mobiledevgraphapp
import android.os.Parcel
import android.os.Parcelable
class Widow(
    var id: String?, var fullName: String?, var dob: String?, var employmentStatus: String?,
    var occupation: String?, var phoneNumber: String?, var address: String?,
    var homeTown: String?, var lga: String?, var senatorialZone: String?, var state: String?,
    var husbandName: String?, var husbandOccupation: String?, var yearOfMarriage: String?,
    var numberOfChildren: String?, var husbandBereavementDate: String?, var oneOrTwo: String?,
    var categoryBasedOnNeeds: String?, var registrationDate: String?, var bankName: String?,
    var accountName: String?, var accountNumber: String?, var ngoName: String?,
    var ngoMembership: String?, var receivedBy: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "Widow(id='$id', fullName='$fullName', dob='$dob', employmentStatus='$employmentStatus'," +
                "occupation='$occupation', phoneNumber='$phoneNumber', address='$address', homeTown='$homeTown'," +
                "lga='$lga', senatorialZone='$senatorialZone', state='$state', husbandName='$husbandName', " +
                "husbandOccupation='$husbandOccupation', yearOfMarriage='$yearOfMarriage', numberOfChildren='$numberOfChildren'," +
                "husbandBereavementDate='$husbandBereavementDate', oneOrTwo='$oneOrTwo', categoryBasedOnNeeds='$categoryBasedOnNeeds'," +
                "registrationDate='$registrationDate', bankName='$bankName', accountName='$accountName', " +
                "accountNumber='$accountNumber', ngoName='$ngoName', ngoMembership='$ngoMembership', receivedBy='$receivedBy'" +
                ")"
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(fullName)
        parcel.writeString(dob)
        parcel.writeString(employmentStatus)
        parcel.writeString(occupation)
        parcel.writeString(phoneNumber)
        parcel.writeString(address)
        parcel.writeString(homeTown)
        parcel.writeString(lga)
        parcel.writeString(senatorialZone)
        parcel.writeString(state)
        parcel.writeString(husbandName)
        parcel.writeString(husbandOccupation)
        parcel.writeString(yearOfMarriage)
        parcel.writeString(numberOfChildren)
        parcel.writeString(husbandBereavementDate)
        parcel.writeString(oneOrTwo)
        parcel.writeString(categoryBasedOnNeeds)
        parcel.writeString(registrationDate)
        parcel.writeString(bankName)
        parcel.writeString(accountName)
        parcel.writeString(accountNumber)
        parcel.writeString(ngoName)
        parcel.writeString(ngoMembership)
        parcel.writeString(receivedBy)
    }

    companion object CREATOR : Parcelable.Creator<Widow> {
        override fun createFromParcel(parcel: Parcel): Widow {
            return Widow(parcel)
        }

        override fun newArray(size: Int): Array<Widow?> {
            return arrayOfNulls(size)
        }
    }
}