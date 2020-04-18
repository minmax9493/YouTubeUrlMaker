package com.example.android.youtubeurlmaker.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Question

/**
 * Created by murodjon on 2020/04/14
 */
class QuestionsAdapter(
    private val listener: ItemClickListener<Question>,
    private val questions:List<Question>
) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        private val nameView by lazy { v.findViewById(R.id.txt_title) as TextView }
        private val dateView by lazy { v.findViewById(R.id.txt_date) as TextView }
        private val statusView by lazy { v.findViewById(R.id.txt_status) as TextView }

        fun bindItem(question: Question){
            nameView.text = question.name
            dateView.text = question.createdAt.toString()
            statusView.text = question.url

            itemView.setOnClickListener {
                listener.onClickListener(it, question)
            }
        }
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = parent.inflate(R.layout.topic_list_item, false)
        return ViewHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuestionsAdapter.ViewHolder, position: Int) {
        holder.bindItem(questions[position])
    }
}