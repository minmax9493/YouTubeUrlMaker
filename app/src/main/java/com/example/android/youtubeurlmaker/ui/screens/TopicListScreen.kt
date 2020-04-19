package com.example.android.youtubeurlmaker.ui.screens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.di.util.DaggerFragment
import com.example.android.youtubeurlmaker.ui.adapter.TopicListAdapter
import com.example.android.youtubeurlmaker.ui.dialogs.ActionBottomDialogFragment
import com.example.android.youtubeurlmaker.ui.dialogs.TopicDialog
import com.example.android.youtubeurlmaker.ui.dialogs.YoutubePlayerDialog
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicListViewModel
import kotlinx.android.synthetic.main.fragment_topic_list.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class TopicListScreen : DaggerFragment(R.layout.fragment_topic_list), TopicListAdapter.ItemClickListener, ActionBottomDialogFragment.ItemClickListener {

    @Inject lateinit var viewModel:TopicListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_topic.setOnClickListener {
            addTopic()
        }

        viewModel.topicsLiveData.observe(viewLifecycleOwner, topicsObserver)
    }

    private val topicsObserver = Observer<List<Topic>>{topics->
        topic_list_view.also {
            it.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            it.adapter = TopicListAdapter(this, topics)
            it.setHasFixedSize(true)
        }
    }

    private fun addTopic(){
        val dialog = TopicDialog()
        dialog.setListener(f = {url, title->
            kotlin.run{
            viewModel.addTopic(title, url); dialog.dismiss()}
        })
        dialog.show(childFragmentManager, "")
    }

    override fun onClickListener(view: View, topic: Topic) {
        val bottomDialogFragment = ActionBottomDialogFragment.newInstance()
        bottomDialogFragment.setListener(this)
        bottomDialogFragment.setData(topic)
        bottomDialogFragment.show(childFragmentManager, ActionBottomDialogFragment.TAG)
    }

    override fun share(topic: Topic) {

    }

    override fun play(topic: Topic) {
        val dialog = YoutubePlayerDialog()
        dialog.setData(topic)
        dialog.setListener(f = {
            kotlin.run{
                dialog.dismiss()
            }
        })
        dialog.show(childFragmentManager, "")
    }

    override fun edit(topic: Topic) {
        val bundleOfTopic = bundleOf("topic" to topic)
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        findNavController().navigate(R.id.action_topicListScreen_to_topicEditorScreen, bundleOfTopic, options)
    }

    override fun delete(topic: Topic) {
        topic?.let { viewModel.deleteTopic(it) }
    }
}
