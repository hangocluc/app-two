package com.example.filechooser.recyleAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filechooser.modle.Animal
import com.example.filechooser.R
import com.example.filechooser.interfacer.ListennerInterface
import kotlinx.android.synthetic.main.row.view.*
import kotlin.collections.ArrayList

class RecycleViewAdapter : RecyclerView.Adapter<RecycleViewAdapter.use> {
    var list: MutableList<Animal> = ArrayList()
    lateinit var context: Context
    lateinit var listener:ListennerInterface
    constructor(context: Context,list:ArrayList<Animal>,listennerInterface: ListennerInterface) {
        this.context = context
        this.list=list
        this.listener=listennerInterface
    }

    inner class use(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBindData(animal: Animal) {
//            itemView.image_row.text = animal.image
            itemView.name_row.text = animal.ten
            itemView.namsinh_row.text = animal.namsinh.toString()
            itemView.tuoi_row.text=animal.tinhtuoi().toString()
            itemView.image_row.setImageURI(animal.imgae)
            itemView.mieuta_row.text = animal.mieuta
            itemView.setOnClickListener {
                listener.send(animal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): use {
        var view: View = LayoutInflater.from(context).inflate(R.layout.row, null)
        return use(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: use, position: Int) {
        holder.onBindData(list.get(position))
    }
}