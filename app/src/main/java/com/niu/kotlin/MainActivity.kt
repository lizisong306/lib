package com.niu.kotlin

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val REGISTER_REQUEST_CODE = 123
        val KEY_NAME="name"
        val KEY_PASSWORD="password"
    }
    var userName =""
    var password = ""
    val fragment =  LoginFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        val fragment = LoginFragment()
        fragmentTransaction.add(R.id.fragment_container,fragment).commit()
        back.setOnClickListener {
//            finish()
            val dialogFragment = ExitDialogFragment()
            dialogFragment.show(supportFragmentManager, "exit")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REGISTER_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){

            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item != null && item?.itemId == android.R.id.home){
            if (item.itemId == android.R.id.home){
                supportFragmentManager.popBackStack()
                return true
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    class ExitDialogFragment():DialogFragment(){
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(activity!!)
            builder.setMessage("确定要退出么?")
                .setPositiveButton("是", DialogInterface.OnClickListener(){
                    dialog, which ->  activity!!.finish()
                })
                .setNegativeButton("否", DialogInterface.OnClickListener(){
                    dialog, which ->
                })
            return builder.create()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (supportFragmentManager.backStackEntryCount === 0){
            val dialogFragment = ExitDialogFragment()
            dialogFragment.show(supportFragmentManager,"exit")
            return true
        }else{
            return super.onKeyDown(keyCode, event)
        }

    }

}