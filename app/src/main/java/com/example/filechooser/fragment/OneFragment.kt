package com.example.filechooser.fragment

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.filechooser.MainActivity
import com.example.filechooser.R
import com.example.filechooser.interfacer.ListennerInterface
import com.example.filechooser.modle.Animal
import com.example.filechooser.modle.Constan
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*


class OneFragment : Fragment() {
    lateinit var listenerOne: ListennerInterface

//    companion object {
//        fun callBack(listennerInterface: ListennerInterface): OneFragment {
//            var fag1 = OneFragment()
//            fag1.listenerOne = listennerInterface
//            return fag1
//        }
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_fragone.setOnClickListener {
            startFileChooser()

        }

        btn_add.setOnClickListener {

//            Log.d("Luc",edt_name_fragone.text.toString())
//            var debug = 1
//            debug = 2
//            debug = 3
           uriImage?.let {
            var intent = Intent()
            intent.putExtra(Constan.KEY_IMAGE, it.toString())
            intent.putExtra(Constan.KEY_NAME, edt_name_fragone.text.toString())
            intent.putExtra(Constan.KEY_NAMSINH, edt_namsinh_fragone.text.toString().toInt())
            intent.putExtra(Constan.KEY_MIEUTA, edt_mieuta_fragone.text.toString())
            intent.setAction(Constan.ANIMAL)
            activity?.sendBroadcast(intent)

            }
                   (activity as MainActivity).update()



        }
        val spanable_name = SpannableString("Moi nhap ten: *")
        spanable_name.setSpan(
            ForegroundColorSpan(Color.RED),
            14, 15,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

        )
        txt_name.text = spanable_name
        val spanable_namsinh = SpannableString("Moi nhap nam sinh: *")
        spanable_namsinh.setSpan(
            ForegroundColorSpan(Color.RED),
            19, 20,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

        )
        txt_namsinh.text = spanable_namsinh

        val spanable_mieuta = SpannableString("Mieu ta: *")
        spanable_mieuta.setSpan(
            ForegroundColorSpan(Color.RED),
            8, 10,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txt_mieuta.text = spanable_mieuta

    }

    private fun startFileChooser() {
        var intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "chooser"), 1)

    }
    var uriImage: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {

            data.data?.let {
                image_fragone.setImageURI(it)
                uriImage = it
            }
//         data.data.let {
//             fath = it
//
//
////                image_fragone.setImageURI(it)
////                uriImage = it
//            }
//
//        }
        }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

//
//}
//
//
    }

    }