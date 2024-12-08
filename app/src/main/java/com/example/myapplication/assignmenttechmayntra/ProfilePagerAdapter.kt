package com.example.myapplication.assignmenttechmayntra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ProfilePagerAdapter(
    private val mContext: Context,
    private val dataList: ArrayList<ProfileListModel>
) :
    RecyclerView.Adapter<ProfilePagerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ShapeableImageView = itemView.findViewById(R.id.profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_pager_profile_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = dataList[position]

//        if (item != null) {
//            val petImage = item.petImage

            // Set user pet Image
            holder.imageView.setImageResource(dataList[position].icon)
//        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}