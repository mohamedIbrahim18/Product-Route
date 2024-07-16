package com.example.productapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


      @BindingAdapter("app:imageUrl")
      fun loadImage(imageView: ImageView, url: String?) {
          Glide.with(imageView.context)
              .load(url)
              .error(R.drawable.image_test)
              .into(imageView)
      }




