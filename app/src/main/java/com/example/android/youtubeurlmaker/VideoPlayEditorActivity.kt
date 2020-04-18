package com.example.android.youtubeurlmaker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_video_play_editor.*


class VideoPlayEditorActivity : AppCompatActivity() {

    lateinit var videoId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play_editor)

        videoId = "cyaxW09wr1M"

        //webview
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {

                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        btn_save.setOnClickListener {  }

        btn_share.setOnClickListener {
            share()
        }

        btn_add.setOnClickListener {  }

        partial_video_title_video_view

        min_input_view

        second_input_view
    }

    fun share(){
        var startInMin:Int?=null
        var startInSec:Int?=0
        var time:String=""
        if(min_input_view.text.isNotEmpty()){
            startInMin =  min_input_view.text.toString().toIntOrNull()
        }

        if(second_input_view.text.isNotEmpty()){
            startInSec =  second_input_view.text.toString().toIntOrNull()
        }

        if (startInMin!=null){
            time="${startInMin}m"
        }

        if (startInSec!=null){
            time+="${startInSec}s"
        }

        //https://youtubetime.com/#
        //http://www.youtube.com/watch?v=KbINHTeJWQw&t=65m52s

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "http://www.youtube.com/watch?v=${videoId}&t=${time}")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Send to")
        startActivity(shareIntent)
    }
}
