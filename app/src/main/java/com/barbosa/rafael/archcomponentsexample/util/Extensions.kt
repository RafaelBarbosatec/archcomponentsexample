package com.barbosa.rafael.archcomponentsexample.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by rafael on 23/10/18.
 */
fun ImageView.loadFromUrl(url:String){
    Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(this)
}