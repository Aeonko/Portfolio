package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.*


@Entity(
    tableName = "technologies_used",
    foreignKeys = [ForeignKey(
        entity = Portfolio::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("portfolioId"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
data class TechnologiesUsed(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var image: String,
    var name: String,
    var portfolioId: Long
)