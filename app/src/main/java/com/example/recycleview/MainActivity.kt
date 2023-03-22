package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView :RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerView)

        var newsImageArray = arrayOf(R.drawable.pic12,R.drawable.pic02, R.drawable.pic03,R.drawable.pic04,R.drawable.pic5,R.drawable.pic06)

        var newsHeadingArray = arrayOf(
            "Rahul Gandhi says he never insulted India on foreign soil, but no narrative because…",
            "Centre should intervene': Tejashwi on reports of attack on Bihar migrants in Tamil Nadu",
            "Uddhav Thackeray's stinging attack: ‘Gomutra didn’t bring Independence",
            "Sisodia a saint, PM will face curse for putting him in jail: Kejriwal in Raipur",
            "Jaishankar doesn't understand, can say what he wants: Rahul Gandhi on China",
            "Bihar team satisfied with TN govt on safety measures for workers in Tirupur"
        )
        val newsContent = arrayOf(
            getString( R.string.news_content), getString(R.string.news_content),
            getString( R.string.news_content), getString(R.string.news_content),
            getString( R.string.news_content), getString(R.string.news_content),
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for (index in newsImageArray.indices){
            val news =News(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)

            val myAdapter = MyAdapter(newsArrayList,this)
            myRecyclerView.adapter = myAdapter
            myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
                override fun onItemClicking(position: Int) {

                    val intent = Intent(this@MainActivity,NewsDetailsActivity::class.java)
                    intent.putExtra("heading" , newsArrayList[position].newsHeading)
                    intent.putExtra("imageId",newsArrayList[position].newsImage)
                    intent.putExtra("newscontent",newsArrayList[position].newsContent)
                    startActivity(intent)
                }

            })
        }

    }
}
