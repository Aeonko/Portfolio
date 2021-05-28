package com.nemanjamiseljic.portfolio.repo

import androidx.lifecycle.asLiveData
import com.nemanjamiseljic.portfolio.roomdb.MyMetaDataDao
import com.nemanjamiseljic.portfolio.roomdb.ProfileDao
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.MyMetaData
import javax.inject.Inject

class Repository @Inject constructor(
    private val profileDao: ProfileDao,
    private val myMetaDataDao: MyMetaDataDao
){

    suspend fun insertProfileEntry(profile: LocalProfile){
        profileDao.insertProfileEntry(localProfile = profile)
    }

    fun observeProfileEntries() = profileDao.observeProfileEntries().asLiveData()






    suspend fun insertMyMetaData(metadata: MyMetaData){
        myMetaDataDao.insertMetaData(metadata = metadata)
    }

    fun observeMyMetaData() = myMetaDataDao.observeMyMetaData().asLiveData()
}