package com.niu.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        this.buttonCancel.setOnClickListener(){

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
            val intent = Intent()
            intent.putExtra("name", name)
            intent.putExtra("password", passWord)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item != null && item ?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onContextItemSelected(item)
    }
}