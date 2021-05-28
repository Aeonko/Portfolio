package com.nemanjamiseljic.portfolio.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.MyMetaData

@Database(entities = [LocalProfile::class,MyMetaData::class],version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun ProfileEntryDao(): ProfileDao
    abstract fun MyMetaDataDao(): MyMetaDataDao
}