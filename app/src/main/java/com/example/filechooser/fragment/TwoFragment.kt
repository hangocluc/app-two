package com.example.filechooser.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filechooser.MainActivity
import com.example.filechooser.modle.Animal
import com.example.filechooser.modle.Constan
import com.example.filechooser.R
import com.example.filechooser.interfacer.ListennerInterface
import com.example.filechooser.recyleAdapter.RecycleViewAdapter
import kotlinx.android.synthetic.main.activity_demo_recyclerview.*
import kotlinx.android.synthetic.main.fragment_three.*


class TwoFragment : Fragment() {
    lateinit var listener : ListennerInterface
    companion object{
        fun convention(listennerInterface: ListennerInterface) :TwoFragment{
            val frag = TwoFragment()
            frag.listener = listennerInterface
            return frag
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_two, container, false)
    }


    val broadcast: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                Constan.ANIMAL -> {
                    var name = intent.extras?.getString(Constan.KEY_NAME)
                    var nams = intent.extras?.getInt(Constan.KEY_NAMSINH)
                    var image = intent.extras?.getString(Constan.KEY_IMAGE)
                    var uriImage: Uri = Uri.parse(image)
                    var mieuta = intent.extras?.getString(Constan.KEY_MIEUTA)

                    if (name != null && mieuta != null && nams != null && uriImage != null) {
                        var animal = Animal(
                            name,
                            nams,
                            mieuta,
                            uriImage
                        )
                        adapter.list.add(animal)
                        adapter.notifyDataSetChanged()
                    } else {
                        print("sai")
                    }
                }
            }


        }

    }

    lateinit var adapter: RecycleViewAdapter
    lateinit var ctx: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener = object : ListennerInterface{
            override fun send(animal: Animal) {
                (activity as MainActivity).updateAnimal(animal)

            }

        }

        adapter = RecycleViewAdapter(ctx, arrayListOf(), listener)
        val intentFilter = IntentFilter()
        intentFilter.addAction(Constan.ANIMAL)
        activity?.registerReceiver(broadcast, intentFilter)
        recycle.layoutManager = LinearLayoutManager(activity)
        recycle.adapter = adapter




//        image_row.setOnClickListener {
//            var intent = Intent()
//            intent.putExtra(Constan.KEY_NAME,name_row.text.toString())
//            intent.putExtra(Constan.KEY_NAMSINH,namsinh_row.text.toString().toInt())
//            intent.putExtra(Constan.KEY_MIEUTA, mieuta_row.text.toString())
//            intent.setAction(Constan.ANIMAL)
//            activity?.sendBroadcast(intent)
//        }
    }

    fun luc(){}
    override fun onDestroy() {
        super.onDestroy()
        super.onStop()
        activity?.unregisterReceiver(broadcast)
    }




}


