package com.jgarcia.presentation.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

private val picasso by lazy { Picasso.get() }

fun ImageView.loadImageFromPath(path: String) {
    picasso.load(path).into(this)
}