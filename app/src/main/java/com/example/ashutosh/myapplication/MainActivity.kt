package com.example.ashutosh.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = arrayListOf<User>()
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))
        list.add(User("Lile Gomes", "ashu@gmail.com", "8972376343", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyjDju0dJ1C9eDY-FuIiUvlVjc0C4G1npg4aRMdc5MyT_fievs5w", "12/05/1989"))


        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val decoration = DividerItemDecoration(applicationContext, VERTICAL)
        recyclerView.addItemDecoration(decoration)
        recyclerView.adapter = MyCustomRecyclerViewAdapter(this, list)


    }

}
