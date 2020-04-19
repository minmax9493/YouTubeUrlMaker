package com.example.android.youtubeurlmaker.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.youtubeurlmaker.R
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by murodjon on 2020/04/19
 */
class ActionBottomDialogFragment : BottomSheetDialogFragment(),
    View.OnClickListener {
    
    var t:Topic? = null
    private var mListener: ItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.action_bottom_sheet, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.txt_play_view).setOnClickListener(this)
        view.findViewById<View>(R.id.txt_share_view).setOnClickListener(this)
        view.findViewById<View>(R.id.txt_editor_view).setOnClickListener(this)
        view.findViewById<View>(R.id.txt_delete_view).setOnClickListener(this)
    }

    fun setListener(listener: ItemClickListener){
        this.mListener = listener
    }

    fun setData(data: Topic){
        t = data
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(view: View) {
        val tvSelected = view as TextView
        when(tvSelected.id){
            R.id.txt_delete_view->mListener!!.delete(t!!)
            R.id.txt_editor_view->mListener!!.edit(t!!)
            R.id.txt_share_view->mListener!!.share(t!!)
            R.id.txt_play_view->mListener!!.play(t!!)
        }
        dismiss()
    }

    interface ItemClickListener {
        fun share(t: Topic)
        fun play(t: Topic)
        fun edit(t: Topic)
        fun delete(t: Topic)
    }

    companion object {
        const val TAG = "ActionBottomDialog"
        fun newInstance(): ActionBottomDialogFragment {
            return ActionBottomDialogFragment()
        } 
    }
}