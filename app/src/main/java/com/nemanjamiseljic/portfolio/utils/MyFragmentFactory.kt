package com.nemanjamiseljic.portfolio.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.nemanjamiseljic.portfolio.screens.profile.ProfileAdapter
import com.nemanjamiseljic.portfolio.screens.profile.ProfileFragment
import javax.inject.Inject

class MyFragmentFactory @Inject constructor(
    private val glide: RequestManager,
    private val profileAdapter: ProfileAdapter
): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when(className){
            ProfileFragment::class.java.name -> ProfileFragment(glide = glide,profileAdapter = profileAdapter)
            else ->   return super.instantiate(classLoader, className)
        }
    }
}