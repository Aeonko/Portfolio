package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "images_urls",
    foreignKeys = [ForeignKey(
        entity = Portfolio::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("portfolioId"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
class ImagesUrls (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var url: String,
    var portfolioId: Long
)

