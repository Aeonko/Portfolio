package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experience")
data class Experience(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var imageHeaderUrl: String,
    var jobTitle: String,
    var companyName: String,
    var location: String,
    var locationLatitude: Long,
    var locationLongitude: Long,
    var workedFromDateToDate: String,
    var playStoreUrl: String,
    var webCiteUrls: String,
    var info: String
) {
}