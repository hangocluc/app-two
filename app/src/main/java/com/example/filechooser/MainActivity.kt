package com.example.filechooser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filechooser.ViewpagerAdapter.ViewpagerAdapter
import com.example.filechooser.fragment.OneFragment
import com.example.filechooser.fragment.ThreeFragment
import com.example.filechooser.fragment.TwoFragment
import com.example.filechooser.modle.Animal
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var viewpagerAdapter = ViewpagerAdapter(supportFragmentManager)

    //    var listeer = object : ListennerInterface {
//        override fun send(animal: Animal) {
//
//        }
//    }
    fun update() {
        val frag: TwoFragment =
            viewpagerAdapter.instantiateItem(viewpager, 1) as TwoFragment
        frag.luc()
        viewpager.currentItem = 1
    }

    var animal: Animal? = null
    fun updateAnimal(animal: Animal) {
        this.animal = animal
        val fragment: ThreeFragment =
            viewpagerAdapter.instantiateItem(viewpager, 2) as ThreeFragment
        fragment.handleAnimal(animal)
        viewpager.currentItem = 2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpagerAdapter.addList(OneFragment(), "One")
        viewpagerAdapter.addList(TwoFragment(), "Two")
        viewpagerAdapter.addList(ThreeFragment(), "Three")
        viewpager.adapter = viewpagerAdapter


        tablayout.setupWithViewPager(viewpager)

    }

}




