package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "meta_data",
    indices = [Index(value = ["firstName", "lastName"], unique = true)]
)
data class MyMetaData(
    val firstName: String = "",
    val lastName: String = "",
    val jobTitle: String = "",
    val profilePictureUrl: String = "",
    val greetingMessage: String = "",
    val greetingMessageIcon: String = "",
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)