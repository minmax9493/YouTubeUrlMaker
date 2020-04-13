package io.youvr.android.pivopresenter.di.util

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class DaggerFragment(@LayoutRes resId:Int):Fragment(resId){
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
