package com.nemanjamiseljic.portfolio.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile

@Database(entities = [LocalProfile::class],version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun ProfileEntryDao(): ProfileDao
}