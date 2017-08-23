package com.example.maueki.myfragmentapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), TitlesFragment.OnTitleSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTitleSelected(position: Int) {
        val detailFragment = DetailFragment.newInstance(position)
        supportFragmentManager.beginTransaction()
                .replace(R.id.detailFrame, detailFragment)
                .commit()

    }
}
