package com.nemanjamiseljic.portfolio.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.nemanjamiseljic.portfolio.R
import com.nemanjamiseljic.portfolio.roomdb.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectFireStore() = FirebaseFirestore.getInstance()


    @Singleton
    @Provides
    fun injectProfileDao(database: LocalDatabase) = database.ProfileEntryDao()


    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, LocalDatabase::class.java, "portfolioDB").build()


    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
    )

}