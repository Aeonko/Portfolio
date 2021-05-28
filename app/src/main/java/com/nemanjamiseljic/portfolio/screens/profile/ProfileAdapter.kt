package com.nemanjamiseljic.portfolio.screens.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nemanjamiseljic.portfolio.databinding.RecyclerviewCardProfileBinding
import com.nemanjamiseljic.portfolio.roomdb.dataclasses.LocalProfile

class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    inner class ProfileViewHolder(private val binding: RecyclerviewCardProfileBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(localProfile: LocalProfile){
            binding.apply {
                rcpTitle.text = localProfile.title
                rcpMessage.text = localProfile.message
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<LocalProfile>(){
        override fun areItemsTheSame(oldItem: LocalProfile, newItem: LocalProfile)= oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: LocalProfile, newItem: LocalProfile)= oldItem == newItem
    }
    val differ = AsyncListDiffer(this,differCallBack)

//    var profileEntries: List<LocalProfile>
//    get() = differ.currentList
//    set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val  view = RecyclerviewCardProfileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size
}