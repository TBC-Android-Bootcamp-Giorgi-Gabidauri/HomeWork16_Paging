package com.gabo.paging.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gabo.paging.model.UserModel

class UserDiffCallBack : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}