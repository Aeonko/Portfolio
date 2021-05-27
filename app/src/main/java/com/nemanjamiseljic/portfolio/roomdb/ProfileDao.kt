package com.nemanjamiseljic.portfolio.roomdb


import androidx.room.*
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile
import kotlinx.coroutines.flow.Flow


@Dao
interface ProfileDao {


    @Insert (onConflict = OnConflictStrategy.ABORT)
    suspend fun insertProfileEntry(localProfile: LocalProfile)

    @Update
    suspend fun updateProfile(localProfile: LocalProfile)


    @Delete
    suspend fun deleteProfileEntry(localProfile: LocalProfile)


    @Query("SELECT * FROM profile_entries ORDER BY orderInView ASC")
    fun observeProfileEntries(): Flow<List<LocalProfile>>
}