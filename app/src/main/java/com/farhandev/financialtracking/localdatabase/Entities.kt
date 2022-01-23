package com.farhandev.financialtracking.localdatabase

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "occupation")
    var occupation: String? = null,

    @ColumnInfo(name = "address")
    var address: String? = null,

    @ColumnInfo(name = "phone")
    var phone: String? = null
): Parcelable

@Entity
@Parcelize
data class FinancialTracking(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "spendingValue")
    var spendingValue: Int = 0,

    @ColumnInfo(name = "description")
    var desc: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null
):Parcelable