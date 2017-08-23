package com.example.maueki.myfragmentapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_detail.*
import kotlinx.android.synthetic.main.view_detail.view.*

/**
 * Created by maueki on 17/08/22.
 */
class DetailFragment() : Fragment() {
    companion object {
        fun newInstance(position: Int): DetailFragment {
            return DetailFragment().apply {
                val args = Bundle()
                args.putInt("position", position)
                setArguments(args)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.view_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        detailText.text = News.Details[getArguments().getInt("position")]
    }
}