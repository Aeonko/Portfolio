package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "responsibilities",
    foreignKeys = [ForeignKey(
        entity = Experience::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("experienceId"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
data class Responsibilities(
    val id: Long? = null,
    val responsibility: String,
    val experienceId: Long,
)