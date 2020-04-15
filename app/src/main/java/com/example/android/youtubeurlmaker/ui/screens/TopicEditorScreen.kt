package com.example.android.youtubeurlmaker.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.di.util.DaggerFragment
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicEditorViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TopicEditorScreen : DaggerFragment(R.layout.fragment_topic_editor_screen) {

    @Inject lateinit var viewModel:TopicEditorViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("TopicEditorScreen", "TopicEditor")

    }
}
