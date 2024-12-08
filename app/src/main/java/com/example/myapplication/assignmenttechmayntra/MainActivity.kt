package com.example.myapplication.assignmenttechmayntra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var profileListRecyclerView: RecyclerView
    private lateinit var viewPagerProfilePic: ViewPager2


    private lateinit var profileListRecyclerAdapter : ProfileListRecyclerAdapter
    private lateinit var profilePagerAdapter : ProfilePagerAdapter
    private lateinit var layoutManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileListRecyclerView = findViewById(R.id.profile_list_recycler_view)
        viewPagerProfilePic = findViewById(R.id.viewPagerProfilePic)

        setProfileRecycler(dataList())
        initViewPager(dataList())
    }

    private fun dataList(): ArrayList<ProfileListModel> {

        return arrayListOf(
            ProfileListModel(R.drawable.ic_flaky, "profile1"),
            ProfileListModel(R.drawable.ic_emoji, "profile2"),
            ProfileListModel(R.drawable.ic_tag_face, "profile3"),
            ProfileListModel(R.drawable.ic_flaky, "profile1"),
            ProfileListModel(R.drawable.ic_emoji, "profile2"),
            ProfileListModel(R.drawable.ic_tag_face, "profile3"),
            ProfileListModel(R.drawable.ic_flaky, "profile1"),
            ProfileListModel(R.drawable.ic_emoji, "profile2"),
            ProfileListModel(R.drawable.ic_tag_face, "profile3"),
            ProfileListModel(R.drawable.ic_flaky, "profile1"),
            ProfileListModel(R.drawable.ic_emoji, "profile2"),
            ProfileListModel(R.drawable.ic_tag_face, "profile3")
        )
    }



    private fun setProfileRecycler(profileList: ArrayList<ProfileListModel>) {

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        profileListRecyclerAdapter = ProfileListRecyclerAdapter(this, profileList)

//        profileListRecyclerView.offsetLeftAndRight(14)

        profileListRecyclerView.addItemDecoration(MyItemDecoration())

        profileListRecyclerView.layoutManager = layoutManager
        profileListRecyclerView.adapter = profileListRecyclerAdapter
    }

    private fun initViewPager(profileList: ArrayList<ProfileListModel>) {

        profilePagerAdapter = ProfilePagerAdapter(this, profileList)

        viewPagerProfilePic.getChildAt(0).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        viewPagerProfilePic.apply {
            adapter = profilePagerAdapter
            offscreenPageLimit = profileList.size
            setPageTransformer(SliderTransformer(offscreenPageLimit = profileList.size))
        }

    }
}