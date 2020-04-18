package com.example.android.youtubeurlmaker.ui.dialogs

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.android.youtubeurlmaker.R
import kotlinx.android.synthetic.main.topic_dialog_layout.*

/**
 * Created by murodjon on 2020/04/18
 */
class TopicDialog : DialogFragment() {

    private var listener: ((String, String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.topic_dialog_layout, container, false)
        // Set transparent background and no title
        if (dialog != null && dialog!!.window != null) {
            //dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_cancel.setOnClickListener { this.dismiss() }
        btn_ok.setOnClickListener {
            val title = title_view.text.toString()
            val url = url_view.text.toString()

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(url)) {
                Toast.makeText(
                    requireContext(),
                    R.string.empty_space_not_allowed,
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val pattern = "^(http(s)?:\\/\\/)?((w){3}.)?youtu(be|.be)?(\\.com)?\\/.+"

            if (!TextUtils.isEmpty(url) && !url.matches(pattern.toRegex())) {
                Toast.makeText(
                    requireContext(),
                    R.string.url_not_valid,
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            listener?.invoke(title, url)
        }
    }

    fun setListener(f: (String, String) -> Unit) {
        listener = f
    }
}