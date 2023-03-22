package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId",R.drawable.pic12)
        val newsContent = intent.getStringExtra("newscontent")

        val headingTv = findViewById<TextView>(R.id.newsHeading)
        val imageTv = findViewById<ImageView>(R.id.newsImage)
        val newsContentTv = findViewById<TextView>(R.id.newcontent)

        headingTv.text = heading
        imageTv.setImageResource(imageId)
        newsContentTv.text =newsContent
    }
}