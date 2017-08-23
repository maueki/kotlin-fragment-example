package com.example.maueki.myfragmentapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val position = intent.getIntExtra(TitlesFragment.EXTRA_POSITION, 0)
        val detailFragment = DetailFragment.newInstance(position)
        supportFragmentManager.beginTransaction()
                .add(R.id.detailFrame, detailFragment)
                .commit()
    }
}
