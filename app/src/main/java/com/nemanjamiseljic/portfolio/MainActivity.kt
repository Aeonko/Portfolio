package com.nemanjamiseljic.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.nemanjamiseljic.portfolio.screens.utils.MyFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG by lazy { MainActivity::class.java.name }

    @Inject
    lateinit var fragmentFactory: MyFragmentFactory



    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_main)
        viewModel.startListeningForChangesInFirebaseProfileEntries()

        viewModel.profileEntries.observe(this, {
            it.forEach {
                Log.d(TAG, "MainActivity profile entry: ${it.title} : ID : ${it.id} ")
            }
        })
    }
}