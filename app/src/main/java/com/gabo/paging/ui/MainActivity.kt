package com.gabo.paging.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabo.paging.adapter.UserLoadingAdapter
import com.gabo.paging.adapter.UsersAdapter
import com.gabo.paging.databinding.ActivityMainBinding
import com.mikepenz.itemanimators.AlphaInAnimator
import kotlinx.android.synthetic.main.loading_item.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainVM by viewModel()
    private val adapter : UsersAdapter by lazy {
        UsersAdapter().also {
            binding.rvUsers.adapter = it.withLoadStateHeaderAndFooter(
                header = UserLoadingAdapter(this) { it.retry() },
                footer = UserLoadingAdapter(this) { it.retry() })
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
            binding.rvUsers.itemAnimator = AlphaInAnimator()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getUsers().collect{
                    adapter.submitData(it)
                }
                adapter.loadStateFlow.collect { loadStates ->
                    pfRetryState.isVisible = loadStates.refresh !is LoadState.Loading
                }
            }
        }
    }
}