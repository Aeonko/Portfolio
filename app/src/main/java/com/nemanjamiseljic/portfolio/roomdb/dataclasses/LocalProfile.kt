package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "profile_entries",indices = [Index(value = ["title"], unique = true)])
data class LocalProfile(
    var title: String = "",
    var message: String = "",
    var orderInView: Long = 0,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)