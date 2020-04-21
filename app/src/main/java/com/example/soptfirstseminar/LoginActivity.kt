package com.example.soptfirstseminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activiry_relativelogin.*

class LoginActivity : AppCompatActivity() {

    private val REGISTER_ACTIVITY_REQUEST_CODE = 0
    private var password:String = "123451245"
    private var idAdress:String = "defaultPassword"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiry_relativelogin)

        bt_login.setOnClickListener{
            if(et_mail.text.isNullOrBlank() || et_password.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else{
                if(password.isNullOrBlank() || idAdress.isNullOrBlank()) {
                    Toast.makeText(this, "회원가입하셔서 회원정보 만들어 오세요", Toast.LENGTH_SHORT).show()
                }else if(et_mail.text.toString() == idAdress && et_password.text.toString() == password){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "아이디와 비밀번호를 다시 확인하세요.", Toast.LENGTH_SHORT).show()
                }

            }
        }
        tv_register.setOnClickListener{
            //Log.d("beforeIntent", "Before Intent")
            val intent = Intent(this, RegisterActivity::class.java)
            //Log.d("afterIntent", "After Intent")
            startActivityForResult(intent, REGISTER_ACTIVITY_REQUEST_CODE)

            Log.d("finish", "finish")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REGISTER_ACTIVITY_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val datas = data!!.getStringArrayExtra("datas")
                password = datas[1]
                idAdress = datas[0]
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}
