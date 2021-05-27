package com.nemanjamiseljic.portfolio.screens.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.nemanjamiseljic.portfolio.screens.profile.ProfileFragment

class MyFragmentFactory(
    private val glide: RequestManager,
): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when(className){
            ProfileFragment::class.java.name -> ProfileFragment(glide = glide)
            else ->   return super.instantiate(classLoader, className)
        }
    }
}