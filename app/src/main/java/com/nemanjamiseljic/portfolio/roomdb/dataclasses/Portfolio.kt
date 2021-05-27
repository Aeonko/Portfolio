package com.nemanjamiseljic.portfolio.roomdb.dataclasses

import androidx.room.Entity

@Entity(tableName = "portfolio_entries")
data class Portfolio(
    var headerImageUrl: String,
    var title: String,
    var dateLong: Long,
    var date: String,
    var githubUrl: String,
    var playStoreUrl: String,
    var messageOne: String,
    var messageTwo: String,
    var favorite: Boolean,
)