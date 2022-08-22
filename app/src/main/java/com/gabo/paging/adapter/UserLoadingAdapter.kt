package com.gabo.paging.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gabo.paging.R
import com.gabo.paging.databinding.LoadingItemBinding

class UserLoadingAdapter(
    private val context:Context,
    private val retry: () -> Unit
) : LoadStateAdapter<UserLoadingAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState, retry,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = LoadingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(binding)
    }

    class LoadStateViewHolder(private val binding: LoadingItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(loadState: LoadState,retry: () -> Unit, context: Context){
            with(binding){
                pfRetryState.isVisible = loadState !is LoadState.Loading
                pfErrorState.isVisible = loadState !is LoadState.Loading
                pfProgressState.isVisible = loadState is LoadState.Loading
                if (loadState is LoadState.Error) {
                    pfErrorState.text = context.getString(R.string.network_error)
                }
                pfRetryState.setOnClickListener {
                    retry.invoke()
                }
            }
        }
    }
}

