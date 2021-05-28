package com.nemanjamiseljic.portfolio.screens.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.nemanjamiseljic.portfolio.MainViewModel
import com.nemanjamiseljic.portfolio.R
import com.nemanjamiseljic.portfolio.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment @Inject constructor(
    private val glide: RequestManager,
    private val profileAdapter: ProfileAdapter
): Fragment(R.layout.fragment_profile) {

    val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentProfileBinding
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)
        binding.apply {
            fpRecyclerView.apply {
                hasFixedSize()
                layoutManager= LinearLayoutManager(requireContext())
                adapter = profileAdapter
            }
        }

        mainViewModel.profileEntries.observe(viewLifecycleOwner,{
            profileAdapter.differ.submitList(it)
        })

        mainViewModel.metaData.observe(viewLifecycleOwner,{ listOfMyMetaData->
            if(listOfMyMetaData.isNotEmpty()){
                val myMetaData = listOfMyMetaData[0]
                binding.apply {
                    fpGreetingMessage.text = myMetaData.greetingMessage
                    fpFirstLastName.text = "${myMetaData.firstName} ${myMetaData.lastName}"
                    fpJobDescription.text = myMetaData.jobTitle
                    glide.load(myMetaData.profilePictureUrl).into(fpProfileImageView)
                }
            }

        })


    }
}