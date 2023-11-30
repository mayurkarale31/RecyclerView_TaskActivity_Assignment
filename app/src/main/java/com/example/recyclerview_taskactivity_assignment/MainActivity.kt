package com.example.recyclerview_taskactivity_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerMessage : RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val post = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerMessage = findViewById(R.id.recyclerMessage)

        initData()

        postAdapter = PostAdapter(post)
        postAdapter.onPostClickListener = MyPostClickListener()
        recyclerMessage.adapter = postAdapter


        recyclerMessage.layoutManager=
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

    inner class MyPostClickListener: PostAdapter.OnPostClickListener{
        override fun onPostClick(position: Int, post: Post, view: View) {
            Toast.makeText(
                this@MainActivity,
                "My Action ${position+1} is clicked...",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun initData(){
        post.add(Post(
            11,
            "Project Title : Find Roomie",
            "Description : Help to find roommate",
            "Due Date : 31-12-2023",
            "Status : In Process"
        ))
        post.add(Post(
            12,
            "Project Title : GateSec",
            "Description : Security Gate",
            "Due Date : 31-12-2023",
            "Status : Done"
        ))
        post.add(Post(
            13,
            "Project Title : Job Portal",
            "Description : Help to find job for freshers only",
            "Due Date : 30-12-2023",
            "Status : In Process"
        ))
        post.add(Post(
            14,
            "Project Title : E-Shopping",
            "Description : E-commerce platform for handcraft material",
            "Due Date : 31-12-2023",
            "Status : Cancel"
        ))
    }
}