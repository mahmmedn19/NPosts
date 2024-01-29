package com.monaser.nposts.presentation.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.monaser.nposts.R
import com.monaser.nposts.presentation.base.BaseAdapter

@BindingAdapter("app:showIfTrue")
fun showIfTrue(view: View, condition: Boolean) {
    view.isVisible = condition
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter("app:loadImage")
fun bindImage(image: ImageView, imageURL: String?) {
    imageURL?.let {
        Glide.with(image)
            .load(imageURL)
            .placeholder(R.drawable.loading_animation)
            .centerCrop().into(image)
    }
}

@BindingAdapter("app:showPlaceholder")
fun showPlaceholder(imageView: ImageView, show: Boolean) {
    if (show) {
        imageView.visibility = View.VISIBLE
    } else {
        imageView.visibility = View.GONE
    }
}

