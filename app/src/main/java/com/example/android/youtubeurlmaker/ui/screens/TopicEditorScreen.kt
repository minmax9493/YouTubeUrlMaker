package com.example.android.youtubeurlmaker.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.android.youtubeurlmaker.R

/**
 * A simple [Fragment] subclass.
 */
class TopicEditorScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic_editor_screen, container, false)
    }

}
