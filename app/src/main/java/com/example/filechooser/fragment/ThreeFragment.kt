package com.example.filechooser.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.filechooser.R
import com.example.filechooser.modle.Animal
import kotlinx.android.synthetic.main.fragment_three.*


class ThreeFragment : Fragment() {
    //lateinit var list:ListennerInterface
    var animal: Animal? = null

    //    companion object{
//        fun convention3(listennerInterface: ListennerInterface) :ThreeFragment{
//            val frag3 = ThreeFragment()
//            frag3.list= listennerInterface
//            return frag3
//        }
//
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    fun handleAnimal(animal: Animal) {

        this.animal = animal
        image_fragthree.setImageURI(animal.imgae)
        txt_name_fragmentthree.text = animal.ten
        txt_namsinh_fragmentthree.text = animal.namsinh.toString()
        txt_tuoi_fragmentthree.text = animal.tinhtuoi().toString()
        txt_mieuta_fragmentthree.text = animal.mieuta

    }


}