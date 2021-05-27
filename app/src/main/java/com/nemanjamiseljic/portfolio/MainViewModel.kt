package com.nemanjamiseljic.portfolio

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.nemanjamiseljic.portfolio.repo.Repository
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile
import com.nemanjamiseljic.portfolio.roomdb.firestore.FirestoreProfile
import com.nemanjamiseljic.portfolio.screens.utils.Utils.FIRESTORE_PATH_PROFILE
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val firebaseFirestore: FirebaseFirestore,
    private val repository: Repository,
) : ViewModel(){
    private val TAG by lazy { MainViewModel::class.java.name }

//    init {
//       startListeningForChangesInFirebaseProfileEntries()
//    }
    val profileEntries = repository.observeProfileEntries()

    fun startListeningForChangesInFirebaseProfileEntries(){
        Log.d(TAG, "MainViewModel initialized: ")
        val reference = firebaseFirestore.collection(FIRESTORE_PATH_PROFILE)
        reference.addSnapshotListener { value, error ->
            if(error != null){
                Log.d(TAG, "startListeningForChangesInFirebaseProfileEntries: value is null")
                //Todo inform user that his data couldnt be fatched
                return@addSnapshotListener
            }

            if(value != null ){
                val receivedData = value.toObjects(LocalProfile::class.java)
                receivedData.forEach {localProfileEntry->
                    Log.d(TAG, "startListeningForChangesInFirebaseProfileEntries: ${localProfileEntry.title}")

                    viewModelScope.launch {
                        repository.insertProfileEntry(profile = localProfileEntry)
                    }
                }
            }
        }
    }
}