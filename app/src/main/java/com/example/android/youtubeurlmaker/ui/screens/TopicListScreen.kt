package com.example.android.youtubeurlmaker.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.di.util.DaggerFragment
import com.example.android.youtubeurlmaker.ui.adapter.TopicListAdapter
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicListViewModel
import kotlinx.android.synthetic.main.fragment_topic_list.*
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TopicListScreen : DaggerFragment(R.layout.fragment_topic_list), TopicListAdapter.ItemClickListener {

    @Inject lateinit var viewModel:TopicListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_topic.setOnClickListener { viewModel.addTopic("https://www.youtube.com/watch?v=m1BZnyWCwL4", "Lightning nasheed") }

        viewModel.topicsLiveData.observe(viewLifecycleOwner, topicsObserver)
        viewModel.openEditorLiveData.observe(viewLifecycleOwner, openEditorObserver)
    }

    private val topicsObserver = Observer<List<Topic>>{topics->
        topic_list_view.also {
            it.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            it.adapter = TopicListAdapter(this, topics)
            it.setHasFixedSize(true)
        }
    }

    private val openEditorObserver = Observer<Unit> { findNavController().navigate(R.id.action_topicListScreen_to_topicEditorScreen) }

    override fun onClickListener(view: View, topic: Topic) {
        viewModel.openTopicEditor(topic)
    }
}
