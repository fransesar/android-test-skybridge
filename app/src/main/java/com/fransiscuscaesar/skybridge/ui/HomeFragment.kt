package com.fransiscuscaesar.skybridge.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fransiscuscaesar.skybridge.R
import com.fransiscuscaesar.skybridge.util.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private val homeAdapter: HomeAdapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupData()
    }

    private fun setupView() {
        rvMovie.apply {
            layoutManager = LinearLayoutManager(context)
            homeAdapter.setHasStableIds(true)
            adapter = homeAdapter
        }
        btnRetry.setOnClickListener {
            viewModel.getLatestMovies()
        }
    }

    private fun setupData() {
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is State.Loading -> {
                    pbLoading.visibility = View.VISIBLE
                    btnRetry.visibility = View.GONE
                }
                is State.Success -> {
                    pbLoading.visibility = View.GONE
                    btnRetry.visibility = View.GONE
                    homeAdapter.addData(state.data)
                }
                is State.Error -> {
                    pbLoading.visibility = View.GONE
                    btnRetry.visibility = View.VISIBLE
                    Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}