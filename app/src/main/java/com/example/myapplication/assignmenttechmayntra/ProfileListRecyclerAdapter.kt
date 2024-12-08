package com.example.myapplication.assignmenttechmayntra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ProfileListRecyclerAdapter(private val context: Context,
                                 private val dataList: ArrayList<ProfileListModel>
                                 ) : RecyclerView.Adapter<ProfileListRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileIcon: ShapeableImageView = itemView.findViewById(R.id.profile_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.profileIcon.setImageResource(dataList[position].icon)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}