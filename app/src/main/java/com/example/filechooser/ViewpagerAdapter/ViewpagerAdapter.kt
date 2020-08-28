package com.example.filechooser.ViewpagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class ViewpagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    val fragmentList:MutableList<Fragment> = ArrayList()
    val titleList:MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
    fun addList(fragment: Fragment,title:String){
        fragmentList.add(fragment)
        titleList.add(title)


    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }
}