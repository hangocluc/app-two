package com.example.filechooser.modle

import android.net.Uri
import java.util.*

class Animal(var ten:String, var namsinh: Int, var mieuta:String, var imgae: Uri, var isCheck:Boolean) {
    fun tinhtuoi():Int {
    var today = Calendar.getInstance()
    val age:Int = today.get(Calendar.YEAR)- namsinh
    return age
}
}