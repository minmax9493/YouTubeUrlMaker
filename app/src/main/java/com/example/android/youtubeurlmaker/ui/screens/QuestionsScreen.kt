package com.example.android.youtubeurlmaker.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.di.util.DaggerFragment
import com.example.android.youtubeurlmaker.ui.adapter.ItemClickListener
import com.example.android.youtubeurlmaker.ui.adapter.QuestionsAdapter
import com.example.android.youtubeurlmaker.ui.dialogs.YoutubePlayerDialog
import com.example.android.youtubeurlmaker.ui.viewmodels.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_questions_screen.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class QuestionsScreen : DaggerFragment(R.layout.fragment_questions_screen), ItemClickListener<Question> {

    @Inject lateinit var viewModel:QuestionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.questionsLiveData.observe(viewLifecycleOwner, Observer {questions->
            question_list_view.also {
                it.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                it.adapter = QuestionsAdapter(this, questions)
                it.setHasFixedSize(true)
            }
        })
    }

    override fun onClickListener(view: View, t: Question) {
        val dialog = YoutubePlayerDialog()
        dialog.setQuestion(t)
        dialog.setListener(f = {
            kotlin.run{
             dialog.dismiss()
            }
        })
        dialog.show(childFragmentManager, "")
    }
}
