package com.example.maueki.myfragmentapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

/**
 * Created by maueki on 17/08/22.
 */
class TitlesFragment(): ListFragment() {
    companion object {
        val EXTRA_POSITION = "com.example.maueki.myfragmentapp.POSITION"
    }

    interface OnTitleSelectedListener {
        fun onTitleSelected(position: Int)
    }

    private var listener: OnTitleSelectedListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity !is OnTitleSelectedListener) {
            throw ClassCastException(activity.toString() + " must implemented onTitleSelected")
        } else {
            listener = activity as OnTitleSelectedListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private var isDualPane = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listAdapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, News.Titles)

        val detailFrame = activity.findViewById(R.id.detailFrame)
        isDualPane = detailFrame != null && detailFrame.visibility == View.VISIBLE
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        if (isDualPane) {
            listener!!.onTitleSelected(position)
        } else {
            startActivity(Intent(activity, SubActivity::class.java).apply {
                putExtra(EXTRA_POSITION, position)
            })
        }
    }
}