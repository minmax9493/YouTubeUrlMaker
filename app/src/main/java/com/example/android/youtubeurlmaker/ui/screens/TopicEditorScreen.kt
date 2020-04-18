package com.example.android.youtubeurlmaker.ui.screens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.di.util.DaggerFragment
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicEditorViewModel
import com.example.android.youtubeurlmaker.util.YouTubeHelper
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TopicEditorScreen : DaggerFragment(R.layout.fragment_topic_editor_screen) {

    @Inject lateinit var viewModel:TopicEditorViewModel
    private lateinit var topic:Topic
    var videoId:String?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topic = arguments?.getSerializable("topic") as Topic

        //webview
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                videoId = YouTubeHelper.extractVideoIdFromUrl(topic.url)
                videoId?.let {
                    youTubePlayer.loadVideo(it, 0f)
                    youTubePlayer.play()
                }
            }
        })

        btn_save.setOnClickListener {
            save()
        }

        btn_share.setOnClickListener {
            share()
        }

        btn_add.setOnClickListener {  }
    }

    private fun save():Question{
        val question = Question()

        question.url = generateUrl()
        question.name = partial_video_title_video_view.text.toString()
        question.createdAt = Date()
        question.topicId = topic.id
        viewModel.addQuestion(question)
        return question
    }

    private fun share(){
        val question = save()

        val shareContent = "Title: ${question.name}\nUrl: ${question.url}"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareContent)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Send to")
        startActivity(shareIntent)
    }

    private fun generateUrl():String {
        var startInMin: Int? = null
        var startInSec: Int? = 0
        var time: String = ""
        if (min_input_view.text.isNotEmpty()) {
            startInMin = min_input_view.text.toString().toIntOrNull()
        }

        if (second_input_view.text.isNotEmpty()) {
            startInSec = second_input_view.text.toString().toIntOrNull()
        }

        if (startInMin != null) {
            time = "${startInMin}m"
        }

        if (startInSec != null) {
            time += "${startInSec}s"
        }

        return "http://www.youtube.com/watch?v=${videoId}&t=${time}"
    }
}
