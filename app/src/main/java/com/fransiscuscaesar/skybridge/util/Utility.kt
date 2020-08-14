package com.fransiscuscaesar.skybridge.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.fransiscuscaesar.skybridge.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .placeholder(R.drawable.img_movie_placeholder)
        .into(view)
}

@BindingAdapter("textDate")
fun convertDate(view: TextView, date: String?) {
    date?.let {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        try {
            val dateInMillis = dateFormat.parse(it)?.time
            val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.US)
            val formattedDate = formatter.format(dateInMillis)
            view.text = formattedDate
        } catch (e: Exception){
            view.text = it
        }
    }
}