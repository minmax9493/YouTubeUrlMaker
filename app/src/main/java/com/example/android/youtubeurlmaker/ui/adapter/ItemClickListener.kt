package com.example.android.youtubeurlmaker.ui.adapter

import android.view.View

/**
 * Created by murodjon on 2020/04/18
 */
interface ItemClickListener<T>{
    fun onClickListener(view: View, t: T)
}