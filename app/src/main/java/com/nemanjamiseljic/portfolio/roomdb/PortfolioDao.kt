package com.nemanjamiseljic.portfolio.roomdb

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.Portfolio
import kotlinx.coroutines.flow.Flow

interface PortfolioDao {

    @Insert
    fun insertPortfolioEntry(portfolio: Portfolio): Int

    @Update
    fun updatePortfolioEntry(portfolio: Portfolio): Int

    @Delete
    fun deletePortfolioEntry(portfolio: Portfolio): Int


    @Query("SELECT * FROM portfolio_entries ORDER BY dateLong ASC")
    fun observePortfolioEntries(): Flow<List<Portfolio>>
}