package com.example.android.youtubeurlmaker.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.util.YouTubeHelper
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker
import kotlinx.android.synthetic.main.youtube_player_dialog.*
import android.util.Log
import com.example.android.youtubeurlmaker.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import java.util.regex.Pattern


/**
 * Created by murodjon on 2020/04/18
 */
class YoutubePlayerDialog:DialogFragment() {

    private var listener:(()->Unit)?=null

    companion object{
        private var question: Question?=null
        private var topic:Topic?=null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.youtube_player_dialog, container, false)
        // Set transparent background and no title
        if (dialog != null && dialog!!.window != null) {
//            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //webview
        youtube_player_view.getYouTubePlayerWhenReady(youTubePlayerCallback = object :YouTubePlayerCallback{
            override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                val videoId: String?
                var startTime=0
                if (question!=null){
                    videoId = question!!.urlSettings!!.videoId
                    startTime = question!!.urlSettings?.startTime ?: 0
                }else{
                    videoId = YouTubeHelper.extractVideoIdFromUrl(topic!!.url)
                }

                videoId?.let {
                    youTubePlayer.loadVideo(it, startTime.toFloat())
                    youTubePlayer.play()

//                    val tracker = YouTubePlayerTracker()
//                    youTubePlayer.addListener(tracker)
//
//                    tracker.state
//                    tracker.currentSecond


//                    tracker.videoDuration
//                    tracker.videoId
                }
            }
        })
    }

    fun setListener(f:()->Unit){
        listener = f
    }

    fun <T> setData(t: T){
        when (t){
            is Question->question = t
            is Topic-> topic = t
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        youtube_player_view.release()
    }
}