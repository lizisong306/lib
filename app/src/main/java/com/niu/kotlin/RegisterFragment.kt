package com.niu.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_register.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.buttonCancel
import kotlinx.android.synthetic.main.fragment_register.buttonOk
import kotlinx.android.synthetic.main.fragment_register.editTextAdress
import kotlinx.android.synthetic.main.fragment_register.editTextEmail
import kotlinx.android.synthetic.main.fragment_register.editTextName
import kotlinx.android.synthetic.main.fragment_register.editTextPassword
import kotlinx.android.synthetic.main.fragment_register.editTextPhone
import kotlinx.android.synthetic.main.fragment_register.radioGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCancel.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }
        this.buttonOk.setOnClickListener(){
            val name = editTextName.text.toString()
            val passWord = editTextPassword.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()
            val address = editTextAdress.text.toString()
            var sex = false
            val checkRadioId = radioGroup.checkedRadioButtonId
            if (checkRadioId == R.id.radioMale){
                sex = true
            }
            val mainActivity = activity as MainActivity
            mainActivity.userName = name
            mainActivity.password = passWord
//            mainActivity.fragment.editText.setText()
            activity!!.supportFragmentManager.popBackStack()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}