package com.nemanjamiseljic.portfolio.repo

import androidx.lifecycle.asLiveData
import com.nemanjamiseljic.portfolio.roomdb.ProfileDao
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile
import javax.inject.Inject

class Repository @Inject constructor(
    private val profileDao: ProfileDao,
){

    suspend fun insertProfileEntry(profile: LocalProfile){
        profileDao.insertProfileEntry(localProfile = profile)
    }

    fun observeProfileEntries() = profileDao.observeProfileEntries().asLiveData()
}