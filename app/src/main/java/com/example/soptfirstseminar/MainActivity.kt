package com.example.soptfirstseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activiry_relativelogin.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiry_relativelogin)

        bt_login.setOnClickListener{
            if(et_mail.text.isNullOrBlank() || et_password.text.isNullOrBlank()){
//                Toast.makeText(t
            }
        }
    }
}
