package com.nemanjamiseljic.portfolio.screens.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestManager
import com.nemanjamiseljic.portfolio.R
import javax.inject.Inject

class ProfileFragment @Inject constructor(
    private val glide: RequestManager
): Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}