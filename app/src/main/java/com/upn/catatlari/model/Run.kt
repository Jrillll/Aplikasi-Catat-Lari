package com.upn.catatlari.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "runs")
data class Run(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val runDate: String,
<<<<<<< HEAD
    val runDistanceKm: Int,
    val runDistanceM: Int,
    val runDurationH: Int,
    val runDurationM: Int
=======
    val runDistance: Int,
    val runDuration: Int
>>>>>>> bacb828f80c763f854382b1958fbc7e6dd1d1c2e
) : Parcelable