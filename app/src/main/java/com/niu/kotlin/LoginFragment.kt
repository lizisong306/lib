package com.niu.kotlin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_register.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.button.setOnClickListener{
            val snackbar = Snackbar.make(it,"你点我干啥？", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        register.setOnClickListener{
//            val intent = Intent(activity, RegisterActivity::class.java)
//            startActivityForResult(intent, MainActivity.REGISTER_REQUEST_CODE)
            val fragment = RegisterFragment()
            val fragmentManager = activity!!.supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack("login")
                .commit()
        }
        val mainActivity = activity as MainActivity
        if (mainActivity.userName != null){
            editText.setText(mainActivity.userName)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val mainActivity = activity as MainActivity
        if(mainActivity.userName != null){
            editText.text = Editable.Factory.getInstance().newEditable(mainActivity.userName)
        }
    }
}