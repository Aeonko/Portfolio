package com.nemanjamiseljic.portfolio.roomdb

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.ImagesUrls
import kotlinx.coroutines.flow.Flow

interface ImagesDao {

    @Insert
    fun insertImageUrl(imagesUrls: ImagesUrls)

    @Update
    fun updateImagesUrl(imagesUrls: ImagesUrls)

    @Delete
    fun deleteImagesUrl(imagesUrls: ImagesUrls)

    @Query("SELECT * FROM images_urls WHERE portfolioId=:portfolioId")
    fun observeImagesForPortfolioId(portfolioId: Long): Flow<List<ImagesUrls>>
}