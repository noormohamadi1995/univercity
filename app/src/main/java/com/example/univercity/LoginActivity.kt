package com.example.univercity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    var usernameEdt : TextInputEditText? = null
    var passwordEdt : TextInputEditText? = null
    var btnLogin : MaterialButton? = null
    private var btnForgot : TextView? = null
    var btnEditPassword : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEdt = findViewById(R.id.edt_username)
        passwordEdt = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)
        btnForgot = findViewById(R.id.btn_forgot)
        btnEditPassword = findViewById(R.id.btn_edit)


        btnLogin?.setOnClickListener {
            val username = usernameEdt?.text.toString()
            val password = passwordEdt?.text.toString()

            if (username.isNotEmpty() || password.isNotEmpty()){
                Toast.makeText(this,"ورود موفقیت امیز بود",Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(
                        this@LoginActivity,
                        DashbordActivity::class.java
                    )
                )
                finishAffinity()
            }else{
                Toast.makeText(this,"نام کاربری یا رمز عبور درست نمی باشد.",Toast.LENGTH_SHORT).show()

            }
        }

        btnForgot?.setOnClickListener {
            val intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

    }
}