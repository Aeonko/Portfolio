package com.nemanjamiseljic.portfolio.roomdb

import androidx.room.*
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.MyMetaData
import kotlinx.coroutines.flow.Flow

@Dao
interface MyMetaDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetaData(metadata: MyMetaData)

    @Update
    suspend fun updateMetaData(metadata: MyMetaData)

    @Delete
    suspend fun deleteMetaData(metadata: MyMetaData)

    @Query("SELECT * FROM meta_data")
    fun observeMyMetaData(): Flow<List<MyMetaData>>
}

