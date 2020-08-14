package com.fransiscuscaesar.skybridge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.fransiscuscaesar.skybridge.BR
import com.fransiscuscaesar.skybridge.R
import com.fransiscuscaesar.skybridge.data.models.Movie
import com.fransiscuscaesar.skybridge.databinding.ItemMovieBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {
    private val movieItems: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMovieBinding>(
            inflater,
            R.layout.item_movie,
            parent,
            false
        )
        return MovieViewHolder(view)
    }

    override fun getItemCount() = movieItems.size

    override fun getItemId(position: Int) = movieItems[position].id.toLong()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.setVariable(BR.movie, movieItems[position])
    }

    fun addData(movieList: List<Movie>) {
        clearData()
        movieItems.addAll(movieList)
        notifyDataSetChanged()
    }

    private fun clearData() {
        movieItems.clear()
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}