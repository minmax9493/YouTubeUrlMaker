package com.example.android.youtubeurlmaker.ui.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.data.source.local.entity.YouTubeUrlSettings
import com.example.android.youtubeurlmaker.di.util.DaggerFragment
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicEditorViewModel
import com.example.android.youtubeurlmaker.util.YouTubeHelper
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.btn_add
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.btn_save
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.btn_share
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.min_input_view
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.partial_video_title_video_view
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.second_input_view
import kotlinx.android.synthetic.main.fragment_topic_editor_screen.youtube_player_view
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

    override fun onDestroy() {
        super.onDestroy()
        if(youtube_player_view!=null){
            youtube_player_view.release()
        }
    }

    private fun save(){
        val question = getQuestion()
        question?.let {
            viewModel.addQuestion(it)
            clear()
        }
    }

    private fun share(){
        val question = getQuestion()
        clear()

        var url = "http://www.youtube.com/watch?v=${videoId}&t=${question?.urlSettings?.startTime}s"

        val shareContent = "Title: ${question?.name}\nUrl: ${url}"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareContent)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Send to")
        startActivity(shareIntent)
    }

    private fun getQuestion():Question?{
        val question = Question()

        question.name = partial_video_title_video_view.text.toString()
        question.createdAt = Date()
        question.topicId = topic.id
        question.urlSettings = YouTubeUrlSettings(videoId!!, getStartTime())
        return question
    }

    private fun getStartTime():Int {
        var startInMin: Int? = null
        var startInSec: Int? = 0
        var time: Int
        if (min_input_view.text.isNotEmpty()) {
            startInMin = min_input_view.text.toString().toIntOrNull()
        }

        if (second_input_view.text.isNotEmpty()) {
            startInSec = second_input_view.text.toString().toIntOrNull()
        }

        time = startInMin?.times(60) ?: 0

        time += startInSec?.times(1)?:0

        return time
    }

    private fun clear(){
        partial_video_title_video_view.text.clear()
        min_input_view.text.clear()
        second_input_view.text.clear()
    }
}
