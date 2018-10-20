package com.example.ashutosh.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.child_view.view.*

class MyCustomRecyclerViewAdapter(private val context: Context, private val list: List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.child_view, p0, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name
        val email: TextView = view.email
        val phone: TextView = view.phoneNumber
        val dob: TextView = view.dateOfBirth
        val profileImage: CircleImageView = view.profileImage
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val user = list[position]
        val holder = viewHolder as MyViewHolder
        with(holder) {
            name.text = user.name
            email.text = user.email
            phone.text = user.phone
            dob.text = user.dateOfBirth
            Glide.with(context).load(user.profilePicture).into(profileImage)
        }

    }


}
