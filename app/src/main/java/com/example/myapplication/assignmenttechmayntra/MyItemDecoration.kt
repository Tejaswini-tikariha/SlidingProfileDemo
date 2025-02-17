package com.example.myapplication.assignmenttechmayntra

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyItemDecoration : RecyclerView.ItemDecoration() {

    private val overlapValue = -120

    override fun getItemOffsets(outRect : Rect, view : View, parent : RecyclerView, state : RecyclerView.State) {
        outRect.set(0, 0, overlapValue, 0)  // args is : left,top,right,bottom
    }

}